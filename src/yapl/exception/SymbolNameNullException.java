package yapl.exception;

import yapl.lib.YAPLException;
import yapl.compiler.Yapl;

public class SymbolNameNullException extends YAPLException {
    public SymbolNameNullException(){
        setLineAndColumn(Yapl.token);
        message = String.format("symbol name is null");
    }
}
