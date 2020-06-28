package yapl.exception;

import yapl.compiler.Yapl;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class InvalidRecordFieldException extends YAPLException {
    public InvalidRecordFieldException(String field, String record) {
        message = String.format("invalid field %s of record %s", field, record);
        errorNumber = CompilerError.InvalidReturnType;
        setLineAndColumn(Yapl.token);
    }
}
