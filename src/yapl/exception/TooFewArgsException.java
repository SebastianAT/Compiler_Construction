package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

public class TooFewArgsException extends YAPLException {
    public TooFewArgsException(Token t, Symbol s){
        setLineAndColumn(t);
        message = String.format("too few arguments for procedure %s", s.getName());
        errorNumber = CompilerError.TooFewArgs;
    }
}
