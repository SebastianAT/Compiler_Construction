import yapl.interfaces.Symbol;
import yapl.interfaces.Type;

import javax.lang.model.type.ArrayType;

public class Symbols implements Symbol {

    private Symbol symbol, nextSymbol;
    private String name;
    private Type type;
    private boolean isReference, isGlobal, isReadonly, seen;
    private int offset;

    public Symbols(String name, Symbol symbol){
        this.name = name;
        setKind(symbol.getKind());
    }

    @Override
    public int getKind() {
        return symbol.getKind();
    }

    @Override
    public String getKindString() {
        return symbol.getName();
    }

    @Override
    public void setKind(int kind) {
        this.symbol = symbol;
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

        if(type instanceof ArrayType){
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


}
