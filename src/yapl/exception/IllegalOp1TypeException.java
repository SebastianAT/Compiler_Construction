package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class IllegalOp1TypeException extends YAPLException {
    public IllegalOp1TypeException(Token t){
        setLineAndColumn(t);
        message = String.format("illegal operand types for unary operator %s", t.image);
        errorNumber = CompilerError.IllegalOp1Type;
    }
}
