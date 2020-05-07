import yapl.interfaces.Symbol;
import yapl.interfaces.Symboltable;

public class SymbolsTable implements Symboltable {


    @Override
    public void openScope(boolean isGlobal) {

    }

    @Override
    public void closeScope() {

    }

    @Override
    public void addSymbol(Symbol s) throws YAPLException {

    }

    @Override
    public Symbol lookup(String name) throws YAPLException {
        return null;
    }

    @Override
    public void setParentSymbol(Symbol sym) {

    }

    @Override
    public Symbol getNearestParentSymbol(int kind) {
        return null;
    }

    @Override
    public void setDebug(boolean on) {

    }
}
