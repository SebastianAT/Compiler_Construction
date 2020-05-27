package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class SelecterNotArrayException extends YAPLException {
    public SelecterNotArrayException(Token t){
        setLineAndColumn(t);
        message = String.format("expression after '%s' is not an array type", t.image);
        errorNumber = CompilerError.SelectorNotArray;
    }
}
