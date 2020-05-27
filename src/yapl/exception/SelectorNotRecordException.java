package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class SelectorNotRecordException extends YAPLException {
    public SelectorNotRecordException(Token t){
        setLineAndColumn(t);
        message = String.format("expression before '%s' is not a record type", t.image);
        errorNumber = CompilerError.SelectorNotRecord;
    }
}
