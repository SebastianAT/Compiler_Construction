package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class IllegalEqualOpTypeException extends YAPLException {
    public IllegalEqualOpTypeException(Token t){
        setLineAndColumn(t);
        message = String.format("illegal operand types for equality operator %s", t.image);
        errorNumber = CompilerError.IllegalEqualOpType;
    }
}
