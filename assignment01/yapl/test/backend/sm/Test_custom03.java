package yapl.test.backend.sm;

import java.io.FileOutputStream;
import java.io.IOException;

import yapl.impl.BackendMJ;
import yapl.interfaces.BackendBinSM;
import yapl.interfaces.MemoryRegion;

/**
 * BackendMJ test: printing a string constant.
 * @author Mario Taschwer
 * @version $Id$
 */
public class Test_custom03
{
    /**
     * Usage: java yapl.test.backend.sm.Test1 object_file
     */
    public static void main(String[] args) throws IOException
    {
        BackendBinSM backend = new BackendMJ();
        backend.enterProc("main", 5, true);
        int addrTmp = backend.allocStack(5);
        backend.loadWord(MemoryRegion.STACK, backend.paramOffset(0));
        backend.arrayLength();
        backend.storeWord(MemoryRegion.STACK, addrTmp);
        backend.loadWord(MemoryRegion.STACK, backend.paramOffset(5));
        backend.exitProc("main_end");
        //backend.writeObjectFile(new FileOutputStream("Custom_Test.mj"));
        System.out.println("wrote object file to Custom_Test.mj");
    }
}
