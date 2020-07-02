package yapl.exception;

import yapl.compiler.Token;
import yapl.compiler.Yapl;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class TypeMismatchAssignException extends YAPLException {
    public static Token errorToken;
    public TypeMismatchAssignException(){
        setLineAndColumn(errorToken);
        message = String.format("type mismatch in assignment");
        errorNumber = CompilerError.TypeMismatchAssign;
    }
}
