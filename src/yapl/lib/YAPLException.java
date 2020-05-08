package yapl.lib;

import yapl.interfaces.CompilerError;
import yapl.compiler.Token;

public class YAPLException extends Exception implements CompilerError {

    protected int column;
    protected int errorNumber;
    protected int line;
    protected String message;

    protected void setLineAndColumn(Token t){
        line = t.beginLine;
        column = t.beginColumn;
    }

    @Override
    public int errorNumber() {
        return errorNumber;
    }

    @Override
    public int line() {
        return line;
    }

    @Override
    public int column() {
        return column;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
