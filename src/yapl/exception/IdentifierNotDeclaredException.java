package yapl.exception;

import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;
import yapl.compiler.Yapl;

public class IdentifierNotDeclaredException extends YAPLException {
    public IdentifierNotDeclaredException(String name){
        setLineAndColumn(Yapl.token);
        message = String.format("identifier '%s' not declared", name);
        errorNumber = CompilerError.IdentNotDecl;
    }
}
