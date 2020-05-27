package yapl.exception;

import yapl.compiler.Token;
import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

public class IllegalRetValProcException extends YAPLException {
    public IllegalRetValProcException(Token t, Symbol s){
        setLineAndColumn(t);
        message = String.format("illegal return value in procedure %s (not a function)", s.getName());
        errorNumber = CompilerError.IllegalRetValProc;
    }
}
