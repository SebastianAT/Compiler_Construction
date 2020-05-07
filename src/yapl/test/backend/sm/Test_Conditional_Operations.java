package yapl.test.backend.sm;

import java.io.FileOutputStream;
import java.io.IOException;

import yapl.impl.BackendMJ;
import yapl.interfaces.BackendBinSM;

/**
 * BackendMJ test: printing a string constant.
 * @author Mario Taschwer
 * @version $Id$
 */
public class Test_Conditional_Operations
{
    /**
     * Usage: java yapl.test.backend.sm.Test1 object_file
     */
    public static void main(String[] args) throws IOException
    {
        BackendBinSM backend = new BackendMJ();
        int addrNewline = backend.allocStringConstant("\n");

        backend.enterProc("main", 0, true);
        backend.loadConst(3);
        backend.loadConst(3);
        backend.isEqual();
        backend.writeInteger();         // print 1
        backend.writeString(addrNewline);
        backend.loadConst(4);
        backend.loadConst(4);
        backend.isLessOrEqual();
        backend.writeInteger();         // print 1
        backend.writeString(addrNewline);
        backend.loadConst(3);
        backend.loadConst(2);
        backend.isGreater();
        backend.writeInteger();         // print 1
        backend.writeString(addrNewline);
        backend.loadConst(3);
        backend.loadConst(2);
        backend.isGreaterOrEqual();
        backend.writeInteger();         // print 1
        backend.writeString(addrNewline);
        backend.loadConst(1);
        backend.loadConst(5);
        backend.isLess();
        backend.writeInteger();         // print 1
        backend.exitProc("main_end");
        backend.writeObjectFile(new FileOutputStream(args[0]));
        System.out.println("wrote object file to " + args[0]);
    }
}
