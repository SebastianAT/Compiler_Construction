package yapl.impl;

import yapl.interfaces.Symbol;
import yapl.lib.Type;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class YAPLSymbol implements Symbol {

    private Symbol nextSymbol;
    private int kind;
    private String name;
    private Type type;
    private boolean isReference, isGlobal, isReadonly, seen;
    private int offset;
    private List<Symbol> param = new ArrayList<Symbol>();

    public YAPLSymbol(String name, int kind) {
        this.name = name;
        setKind(kind);
    }

    @Override
    public int getKind() {
        return kind;
    }

    @Override
    public String getKindString() {
        switch (getKind()) {
            case 0:
                return "program";
            case 1:
                return "procedure";
            case 2:
                return "variable";
            case 3:
                return "constant";
            case 4:
                return "typename";
            case 5:
                return "field";
            case 6:
                return "parameter";
            default:
                return "error";
        }
    }

    @Override
    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;

        if (type instanceof ArrayType) {
            isReference = true;
        }
    }

    @Override
    public boolean isReference() {
        return isReference;
    }

    @Override
    public void setReference(boolean isReference) {
        this.isReference = isReference;
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
    public Symbol getNextSymbol() {
        return nextSymbol;
    }

    @Override
    public void setNextSymbol(Symbol symbol) {
        this.nextSymbol = symbol;
    }

    @Override
    public boolean getReturnSeen() {
        return seen;
    }

    @Override
    public void setReturnSeen(boolean seen) {
        this.seen = seen;
    }

    @Override
    public List<Symbol> getParam() {
        return param;
    }

    @Override
    public void setParam(List<Symbol> param) {
        this.param = param;
    }
}
