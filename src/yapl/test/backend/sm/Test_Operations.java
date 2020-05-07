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
public class Test_Operations
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
        backend.neg();
        backend.writeInteger();     // print -3
        backend.writeString(addrNewline);
        backend.loadConst(2);
        backend.loadConst(-1);
        backend.mul();
        backend.writeInteger();     // print -2
        backend.writeString(addrNewline);
        backend.loadConst(4);
        backend.loadConst(2);
        backend.add();
        backend.loadConst(3);
        backend.div();
        backend.writeInteger();     //print 2
        backend.writeString(addrNewline);
        backend.loadConst(4);
        backend.loadConst(2);
        backend.mod();
        backend.loadConst(1);
        backend.or();
        backend.writeInteger();     //print 1
        backend.writeString(addrNewline);
        backend.loadConst(1);
        backend.loadConst(0);
        backend.and();
        backend.writeInteger();     //print 0
        backend.exitProc("main_end");
        backend.writeObjectFile(new FileOutputStream(args[0]));
        System.out.println("wrote object file to " + args[0]);
    }
}
