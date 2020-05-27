package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class IllegalOp2TypeException extends YAPLException {
    public IllegalOp2TypeException(Token t){
        setLineAndColumn(t);
        message = String.format("illegal operand types for binary operator %s", t.image);
        errorNumber = CompilerError.IllegalOp2Type;
    }
}
