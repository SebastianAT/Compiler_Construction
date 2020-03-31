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
public class Test_custom01
{
    /**
     * Usage: java yapl.test.backend.sm.Test1 object_file
     */
    public static void main(String[] args) throws IOException
    {
        BackendBinSM backend = new BackendMJ();
        backend.enterProc("main", 0, true);
        backend.loadConst(3);
        backend.neg();
        backend.writeInteger();
        backend.loadConst(2);
        backend.neg();
        backend.writeInteger();
        backend.loadConst(2);
        backend.loadConst(1);
        backend.add();
        backend.loadConst(2);
        backend.div();
        backend.writeInteger();
        backend.loadConst(4);
        backend.loadConst(2);
        backend.mod();
        backend.loadConst(2);
        backend.and();
        backend.loadConst(5);
        backend.or();
        backend.writeInteger();
        backend.loadConst(-1);
        backend.exitProc("main_end");
        //backend.writeObjectFile(new FileOutputStream("Custom_Test.mj"));
        System.out.println("wrote object file to Custom_Test.mj");
    }
}
