package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class SelectorNotArrayException extends YAPLException {
    public SelectorNotArrayException(Token t){
        setLineAndColumn(t);
        message = String.format("expression before '%s' is not an array type", t.image);
        errorNumber = CompilerError.SelectorNotArray;
    }
}
