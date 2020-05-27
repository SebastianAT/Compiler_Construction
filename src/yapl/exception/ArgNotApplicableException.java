package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

public class ArgNotApplicableException extends YAPLException {
    public ArgNotApplicableException(int argNumber, Symbol s, Token t){
        setLineAndColumn(t);
        message = String.format("argument #%s not applicable to procedure %s", argNumber, s.getName());
        errorNumber = CompilerError.ArgNotApplicable;
    }
}
