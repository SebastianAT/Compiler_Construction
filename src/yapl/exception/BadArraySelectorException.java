package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class BadArraySelectorException extends YAPLException {
    public BadArraySelectorException(Token t){
        setLineAndColumn(t);
        message = String.format("array index or dimension is not an integer type");
        errorNumber = CompilerError.BadArraySelector;
    }
}
