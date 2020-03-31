package yapl.impl;

import yapl.interfaces.*;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BackendMJ implements BackendBinSM {

    private int mainaddr = 0;
    private int inception = -1; //free local word inception
    private ArrayList<Byte> cb; //CodeBytes
    private ArrayList<Byte> sb; //StaticDataBytes
    private HashMap<String, Integer> labels;
    private HashMap<String, List<Integer>> backpatching;
    private ArrayList<Integer> flsp; //free local space pointer - is needed for allocating local variables
    private ArrayList<Integer> cfs; //current frame size - is needed for method @paramOffset


    public BackendMJ() {
        labels = new HashMap<String, Integer>();
        backpatching = new HashMap<String, List<Integer>>();
        cb = new ArrayList<Byte>();
        sb = new ArrayList<Byte>();
        flsp = new ArrayList<Integer>();
        cfs = new ArrayList<Integer>();
    }

    @Override
    public int wordSize() {
        return 4;
    }

    @Override
    public int boolValue(boolean value) {
        if (value) return 1;
        return 0;
    }

    @Override
    public void assignLabel(String label) {
        if (!labels.containsKey(label)) {
            labels.put(label, cb.size());
            if (backpatching.containsKey(label)) {
                for (int addr : backpatching.get(label)) {
                    byte base = (byte) 0xFF;
                    cb.set(addr, (byte) ((base << 8) & cb.size()));
                    cb.set(addr + 1, (byte) (base & cb.size()));
                }
            }
        } else {
            //Label is already used
        }
    }

    @Override
    public void writeObjectFile(OutputStream outStream) throws IOException {
        outStream.write('M');
        outStream.write('J');
        outStream.write(generate4ByteArray(cb.size()));
        outStream.write(generate4ByteArray(sb.size()/wordSize()));
        outStream.write(generate4ByteArray(mainaddr));

        for(Byte b : cb){
            outStream.write(b);
        }

        for (Byte b : sb) {
            outStream.write(b);
        }
    }

    @Override
    public int allocStaticData(int words) {
        int addr = sb.size();
        for (int i = 0; i < words * wordSize(); i++) {
            sb.add((byte) 0);
        }
        return addr;
    }

    @Override
    public int allocStringConstant(String string) {
        int words = 0;
        while (string.length() + 1 > words * 4) words++;
        int addr = allocStaticData(words);
        byte[] sbytes = string.getBytes();
        for (int i = 0; i < sbytes.length; i++) {
            sb.set(addr + i, sbytes[i]);
        }
        return addr;
    }

    @Override
    public int allocStack(int words) {
        int addr = flsp.get(inception);
        flsp.set(inception, addr + words);
        return addr;
    }

    @Override
    public void allocHeap(int words) {
        putBytes(31, 1);
        putBytes(words, 2);
    }

    @Override
    public void storeArrayDim(int dim) {

    }

    @Override
    public void allocArray() {
        //0x20
    }

    @Override
    public void loadConst(int value) {
        if (value <= 5 && value >= 0) {
            putBytes(15 + value, 1);
        } else if (value == -1) {
            putBytes(21, 1);
        } else {
            putBytes(22, 1);
            putBytes(value, 4);
        }
    }

    @Override
    public void loadWord(MemoryRegion region, int offset) {
        if (region.equals(MemoryRegion.STACK)) {
            if (offset < 0) {
                //error
            } else if (offset <= 3) {
                putBytes(2 + offset, 1);
            } else {
                putBytes(1, 1);
                putBytes(offset, 1);
            }
        } else if (region.equals(MemoryRegion.STATIC)) {
            putBytes(11, 1);
            putBytes(offset, 2);
        } else {
            putBytes(13, 1);
            putBytes(offset, 2);
        }
    }

    @Override
    public void storeWord(MemoryRegion region, int offset) {
        if (region.equals(MemoryRegion.STACK)) {
            if (offset < 0) {
                //error
            } else if (offset <= 3) {
                putBytes(7 + offset, 1);
            } else {
                putBytes(6, 1);
                putBytes(offset, 1);
            }
        } else if (region.equals(MemoryRegion.STATIC)) {
            putBytes(12, 1);
            putBytes(offset, 2);
        } else {
            putBytes(14, 1);
            putBytes(offset, 2);
        }
    }

    @Override
    public void loadArrayElement() {
        putBytes(33, 1);
    }

    @Override
    public void storeArrayElement() {
        putBytes(34, 1);
    }

    @Override
    public void arrayLength() {
        putBytes(37, 1);
    }

    @Override
    public void writeInteger() {
        putBytes(51, 1);
    }

    @Override
    public void writeString(int addr) {
        putBytes(55, 1);
        putBytes(addr, 2);
    }

    @Override
    public void neg() {
        putBytes(28, 1);
    }

    @Override
    public void add() {
        putBytes(23, 1);
    }

    @Override
    public void sub() {
        putBytes(24, 1);
    }

    @Override
    public void mul() {
        putBytes(25, 1);
    }

    @Override
    public void div() {
        putBytes(26, 1);
    }

    @Override
    public void mod() {
        putBytes(27, 1);
    }

    @Override
    public void and() {
        add();
        putBytes(30, 1);
    }

    @Override
    public void or() {
        // Geht das umsetzen ohne IF?
    }

    @Override
    public void isEqual() {
        putBytes(40, 1);
        decisionJump();
    }

    @Override
    public void isLess() {
        putBytes(42, 1);
        decisionJump();
    }

    @Override
    public void isLessOrEqual() {
        putBytes(43, 1);
        decisionJump();
    }

    @Override
    public void isGreater() {
        putBytes(44, 1);
        decisionJump();
    }

    @Override
    public void isGreaterOrEqual() {
        putBytes(45, 1);
        decisionJump();
    }

    @Override
    public void branchIf(boolean value, String label) {
        loadConst(1);
        putBytes(40, 1);
        int addr = getAddr(label);
        putBytes(addr, 2);
    }

    @Override
    public void jump(String label) {
        putBytes(39, 1);
        int addr = getAddr(label);
        putBytes(addr, 2);
    }

    @Override
    public void callProc(String label) {
        putBytes(46, 1); //Call
        int addr = getAddr(label);
        putBytes(addr, 2);
    }

    @Override
    public void enterProc(String label, int nParams, boolean main) {
        if (main) {
            mainaddr = cb.size();
        }
        assignLabel(label);
        putBytes(48, 1);
        putBytes(nParams, 1);
        //Todo: how big is the frame size? backpacking for framesize at loadword/storeword
        putBytes(nParams + 20, 1); //atm 5 local variables
        flsp.add(nParams);
        cfs.add(nParams + 20); //atm 5 local variables
        inception++;
    }

    @Override
    public void exitProc(String label) {
        assignLabel(label + "_end");
        putBytes(49, 1);
        putBytes(47, 1);
        flsp.remove(inception);
        cfs.remove(inception);
        inception--;

    }

    @Override
    public int paramOffset(int index) {
        return index + cfs.get(inception);
    }

    private static byte[] generate4ByteArray(int value) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            int offset = (b.length - 1 - i) * 8;
            b[i] = (byte) ((value >>> offset) & 0xFF);
        }
        return b;
    }

    private void backpatch(String label, int addr) {
        if (!backpatching.containsKey(label))
            backpatching.put(label, new ArrayList<Integer>());
        backpatching.get(label).add(addr);
    }

    private int getAddr(String label) {
        if (!labels.containsKey(label)) {
            backpatch(label, cb.size());
            return 0;
        }
        return labels.get(label);
    }

    private void putBytes(int value, int fixsize) {
        byte[] b = generate4ByteArray(value);
        for (int i = b.length - fixsize; i < b.length; i++) {
            cb.add(b[i]);
        }
    }

    private void decisionJump() {
        putBytes(cb.size() + 6, 2);
        loadConst(0);
        putBytes(39, 1);
        putBytes(cb.size() + 3, 2);
        loadConst(1);
    }
}
