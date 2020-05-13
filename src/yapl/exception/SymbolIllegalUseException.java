package yapl.exception;

import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;
import yapl.compiler.Yapl;

public class SymbolIllegalUseException extends YAPLException {
    public SymbolIllegalUseException(Symbol s){
        setLineAndColumn(Yapl.token);
        message = String.format("illegal use of %s '%s'", s.getKindString(), s.getName());
        errorNumber = CompilerError.SymbolIllegalUse;
    }
}
