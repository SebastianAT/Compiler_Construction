package yapl.exception;

import yapl.compiler.Token;
import yapl.compiler.Yapl;
import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

public class InvalidCreationTypeException extends YAPLException {
    public InvalidCreationTypeException(Token t){
        setLineAndColumn(t);
        message = String.format("invalid type used with 'new'");
        errorNumber = CompilerError.InvalidNewType;
    }
}
