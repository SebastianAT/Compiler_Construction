package yapl.exception;

import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;
import yapl.compiler.Yapl;

public class NonArrayTypeException extends YAPLException {
    public NonArrayTypeException(int s, int type){
        setLineAndColumn(Yapl.token);
        message = String.format("symbol %s does not match array type %s", s, type);
    }

}
