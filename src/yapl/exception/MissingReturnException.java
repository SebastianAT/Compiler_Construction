package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

public class MissingReturnException extends YAPLException {
    public MissingReturnException(Token t, Symbol s){
        setLineAndColumn(t);
        message = String.format("missing Return statement in function %s", s.getName());
        errorNumber = CompilerError.MissingReturn;
    }
}
