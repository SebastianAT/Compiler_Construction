package yapl.impl;

import yapl.interfaces.Symbol;
import yapl.interfaces.Symboltable;
import yapl.lib.YAPLException;

public class YAPLSymbolTable implements Symboltable {

    private Scope currentScope = new Scope();

    @Override
    public void openScope(boolean isGlobal) {
        currentScope = new Scope(currentScope);
        currentScope.setGlobal(isGlobal);
    }

    @Override
    public void closeScope() {
        currentScope= currentScope.getParent();
    }

    @Override
    public void addSymbol(Symbol s) throws YAPLException {
        if(s.getName() == null){
            //TODO: throw error;
        }
        currentScope.addSymbol(s);
    }

    @Override
    public Symbol lookup(String name) throws YAPLException {
        if(name == null){
            //TODO: throw error;
        }
        return currentScope.getSymbol(name);
    }

    @Override
    public void setParentSymbol(Symbol sym) {
        currentScope.setpSymbol(sym);
    }

    @Override
    public Symbol getNearestParentSymbol(int kind) {
        Symbol nps = currentScope.getNearestParentSymbol(kind);
        return nps;
    }

    @Override
    public void setDebug(boolean on) {
        //Todo: Warsch nen logger einführen...
    }
}
