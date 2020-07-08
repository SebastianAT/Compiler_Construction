package yapl.impl;

import yapl.interfaces.Attrib;
import yapl.interfaces.Symbol;
import yapl.lib.Type;

public class YAPLAttrib implements Attrib {

    private byte kind;
    private byte register;
    private Type type;
    private boolean isConstant;
    private boolean isGlobal;
    private boolean isReadonly;
    private int offset;

    public YAPLAttrib(Type type) {
        this.type = type;
    }

    public YAPLAttrib(Symbol s){
        this.type = s.getType();
        this.offset = s.getOffset();
        this.isReadonly = s.isReadonly();
        this.isGlobal = s.isGlobal();
        if(s.getKind() == Symbol.Constant){
            this.isConstant = true;
        }

    }

    @Override
    public byte getKind() {
        return kind;
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
        return isReadonly;
    }

    @Override
    public void setReadonly(boolean isReadonly) {
        this.isReadonly = isReadonly;
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
