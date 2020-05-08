package yapl.impl;
import yapl.exception.*;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

import java.util.Hashtable;

public class Scope {

    private Scope parent;
    private Symbol pSymbol;
    private boolean isGlobal;

    private Hashtable<String, Symbol> symbols = new Hashtable<String, Symbol>();

    public Scope(){
        this(null);
    }

    public Scope(Scope parent){
        this.parent = parent;
    }

    public Scope getParent(){
        return parent;
    }

    public Symbol getSymbol(String name) throws YAPLException {
        if(symbols.containsKey(name)){
            return symbols.get(name);
        }

        if(parent == null){
            throw new IdentifierNotDeclaredException(name);
        }
        return parent.getSymbol(name);
    }

    public void addSymbol(Symbol symbol) throws YAPLException {
        String name = symbol.getName();

        if(symbols.containsKey(name)){
            Symbol seekedSymbol = getSymbol(name);
            throw new SymbolAlreadyExistsException(seekedSymbol);
        }

        symbols.put(name, symbol);
        symbol.setGlobal(isGlobal);
    }

    public boolean isGlobal(){
        return isGlobal;
    }

    public void setGlobal(boolean isGlobal){
        this.isGlobal = isGlobal;
    }

    public void setpSymbol(Symbol pSymbol){
        this.pSymbol = pSymbol;
    }

    public Symbol getNearestParentSymbol(int kind){
        if (pSymbol != null && pSymbol.getKind() == kind) return pSymbol;
        if (parent == null) return null;
        return parent.getNearestParentSymbol(kind);
    }


}
