package yapl.exception;

import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;
import yapl.compiler.Yapl;

public class SymbolAlreadyExistsException extends YAPLException {
    public SymbolAlreadyExistsException(Symbol s){
        setLineAndColumn(Yapl.token);
        message = String.format("symbol '%s' already declared in current scope (as %s)", s.getName(), s.getKindString());
        errorNumber = CompilerError.SymbolExists;
    }
}
