package yapl.lib;

import yapl.interfaces.CompilerError;

public class YAPLException extends Exception implements CompilerError {

    protected int column;
    protected int errorNumber;
    protected int line;
    protected String message;

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
