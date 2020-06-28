package yapl.exception;

import yapl.compiler.Yapl;
import yapl.interfaces.CompilerError;
import yapl.interfaces.Symbol;
import yapl.lib.YAPLException;

public class ProcNotFuncExprException extends YAPLException {
    public ProcNotFuncExprException(Symbol s){
        message = String.format("using procedure %s (not a function) in expression", s.getName());
        errorNumber = CompilerError.ProcNotFuncExpr;
        setLineAndColumn(Yapl.token);
    }
}
