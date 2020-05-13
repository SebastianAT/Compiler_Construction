package yapl.exception;

import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;
import yapl.compiler.Yapl;

public class EndIdentifierMismatchException extends YAPLException {
    public EndIdentifierMismatchException(Symbol startSymbol, String endSymbol){
        setLineAndColumn(Yapl.token);
        message = String.format("End %s does not match %s %s", startSymbol.getName(), startSymbol.getKindString(), endSymbol);
        errorNumber = CompilerError.EndIdentMismatch;
    }
}
