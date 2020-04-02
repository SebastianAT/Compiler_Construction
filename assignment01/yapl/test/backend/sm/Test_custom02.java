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
public class Test_custom02
{
    /**
     * Usage: java yapl.test.backend.sm.Test1 object_file
     */
    public static void main(String[] args) throws IOException
    {
        BackendBinSM backend = new BackendMJ();
        backend.enterProc("main", 0, true);
        backend.loadConst(3);
        backend.loadConst(3);
        backend.isEqual();      //todo: add constants for each conditional jump
        backend.isLessOrEqual();
        backend.writeInteger();
        backend.loadConst(2);
        backend.loadConst(3);
        backend.isGreater();
        backend.isGreaterOrEqual();
        backend.writeInteger();
        backend.loadConst(5);
        backend.loadConst(1);
        backend.isLess();
        backend.exitProc("main_end");
        //backend.writeObjectFile(new FileOutputStream("Custom_Test.mj"));
        System.out.println("wrote object file to Custom_Test.mj");
    }
}
