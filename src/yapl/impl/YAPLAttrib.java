package yapl.impl;

import yapl.interfaces.Attrib;
import yapl.lib.Type;

public class YAPLAttrib implements Attrib {

    private byte kind;
    private byte register;
    private Type type;
    private boolean isConstant;
    private boolean isGlobal;
    private int offset;


    @Override
    public byte getKind() {
        switch(kind){
            case 0:
                return Byte.valueOf("Invalid");
            case 1:
                return Byte.valueOf("RegValue");
            case 2:
                return Byte.valueOf("RegAddress");
            case 3:
                return Byte.valueOf("Constant");
            case 4:
                return Byte.valueOf("MemoryOperand");
            case 5:
                return Byte.valueOf("ArrayElement");
            case 6:
                return Byte.valueOf("RecordField");
            default:
                return Byte.valueOf("error");
        }
    }

    @Override
    public void setKind(byte kind) {
        this.kind = kind;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean isConstant() {
        return isConstant;
    }

    @Override
    public void setConstant(boolean isConstant) {
        this.isConstant = isConstant;
    }

    @Override
    public boolean isReadonly() {
        // TODO
        return false;
    }

    @Override
    public void setReadonly(boolean isReadonly) {
        // TODO
    }

    @Override
    public boolean isGlobal() {
        return isGlobal;
    }

    @Override
    public void setGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public byte getRegister() {
        return register;
    }

    @Override
    public void setRegister(byte register) {
        this.register = register;
    }
}
