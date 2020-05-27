package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.lib.YAPLException;

public class IllegalRetValMainException extends YAPLException {
    public IllegalRetValMainException(Token t){
        setLineAndColumn(t);
        message = String.format("illegal return value in main program");
        errorNumber = CompilerError.IllegalRetValMain;
    }
}
