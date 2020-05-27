package yapl.exception;

import yapl.compiler.Yapl;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class TypeMismatchAssignException extends YAPLException {
    public TypeMismatchAssignException(){
        setLineAndColumn(Yapl.token);
        message = String.format("type mismatch in assignment");
        errorNumber = CompilerError.TypeMismatchAssign;
    }
}
