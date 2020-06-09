package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class IllegalRelOpTypeException extends YAPLException {
    public IllegalRelOpTypeException(Token t){
        setLineAndColumn(t);
        message = String.format("non-integer operand types for relational operator %s", t.image);
        errorNumber = CompilerError.IllegalEqualOpType;
    }
}
