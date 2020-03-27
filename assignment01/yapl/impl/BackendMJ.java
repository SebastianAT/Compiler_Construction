package yapl.impl;

import yapl.interfaces.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class BackendMJ implements BackendBinSM {

    private int pc = 0; //ProgrammCount
    private int sc = 0; //StaticCount
    private List<byte> sb = new ArrayList<byte>(); //StaticDataBytes


    @Override
    public int wordSize() {
        return 0 /*System.getProperty("sun.arch.data.model")*/;
    }

    @Override
    public int boolValue(boolean value) {
        if (value) return 1;
        return 0;
    }

    @Override
    public void assignLabel(String label) {

    }

    @Override
    public void writeObjectFile(OutputStream outStream) throws IOException {

    }

    @Override
    public int allocStaticData(int words) {
        sc += words;
        return sc - words;
    }

    @Override
    public int allocStringConstant(String string) {
        int addr = allocStaticData(string.length() + 1);
        byte[] sbytes = string.getBytes();
        for(byte b:sbytes) sb.add(b);
        sb.add((byte) 0);
        return addr;
    }

    @Override
    public int allocStack(int words) {
        //
        return 0;
    }

    @Override
    public void allocHeap(int words) {
        //0x1F XX XX: allocate space on heap with size XX XX
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
        //0x0F - 0x14 : Const 0-5
        //0x15 : -1
        //0x16 XX XX XX XX : Cont with value XX XX XX XX
    }

    @Override
    public void loadWord(MemoryRegion region, int offset) {
        //0x21
    }

    @Override
    public void storeWord(MemoryRegion region, int offset) {
        //0x22
    }

    @Override
    public void loadArrayElement() {

    }

    @Override
    public void storeArrayElement() {

    }

    @Override
    public void arrayLength() {

    }

    @Override
    public void writeInteger() {

    }

    @Override
    public void writeString(int addr) {

    }

    @Override
    public void neg() {
        //0x1C
    }

    @Override
    public void add() {
        //0x17
    }

    @Override
    public void sub() {
        //0x18
    }

    @Override
    public void mul() {
        //0x19
    }

    @Override
    public void div() {
        //0x1A
    }

    @Override
    public void mod() {
        //0x1B
    }

    @Override
    public void and() {
        //Idee: Zuerst add und dann shift right
    }

    @Override
    public void or() {
        // Geht das umsetzen ohne IF?
    }

    @Override
    public void isEqual() {

    }

    @Override
    public void isLess() {

    }

    @Override
    public void isLessOrEqual() {

    }

    @Override
    public void isGreater() {

    }

    @Override
    public void isGreaterOrEqual() {

    }

    @Override
    public void branchIf(boolean value, String label) {

    }

    @Override
    public void jump(String label) {

    }

    @Override
    public void callProc(String label) {

    }

    @Override
    public void enterProc(String label, int nParams, boolean main) {

    }

    @Override
    public void exitProc(String label) {

    }

    @Override
    public int paramOffset(int index) {
        return 0;
    }
}
