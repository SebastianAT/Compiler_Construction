package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class CondNotBoolException extends YAPLException {
    public CondNotBoolException(Token t){
        setLineAndColumn(t);
        message = String.format("condition is not a boolean expression");
        errorNumber = CompilerError.CondNotBool;
    }
}
