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
public class Test_Arrays
{
    /**
     * Usage: java yapl.test.backend.sm.Test1 object_file
     */
    public static void main(String[] args) throws IOException
    {
        BackendBinSM backend = new BackendMJ();
        backend.enterProc("main", 0, true);
        //int addrTmp = backend.allocStack(4);
        int addrA = backend.allocStaticData(1);
        backend.loadWord(MemoryRegion.STACK, backend.paramOffset(4));
        backend.storeWord(MemoryRegion.STACK, 5);

        backend.loadConst(3);
        backend.storeArrayDim(0);
        backend.allocArray();
        backend.arrayLength();
        backend.writeInteger();         // print 3

        backend.exitProc("main_end");
        backend.writeObjectFile(new FileOutputStream(args[0]));
        System.out.println("wrote object file to " + args[0]);
    }
}
