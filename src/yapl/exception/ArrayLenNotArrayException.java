package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class ArrayLenNotArrayException extends YAPLException {
    public ArrayLenNotArrayException(Token t){
        setLineAndColumn(t);
        message = String.format("expression after '#' is not an array type", t.image);
        errorNumber = CompilerError.ArrayLenNotArray;
    }
}
