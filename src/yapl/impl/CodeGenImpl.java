package yapl.impl;

import yapl.compiler.Token;
import yapl.interfaces.Attrib;
import yapl.interfaces.CodeGen;
import yapl.interfaces.Symbol;
import yapl.lib.ArrayType;
import yapl.lib.RecordType;
import yapl.lib.YAPLException;

public class CodeGenImpl implements CodeGen {


    @Override
    public String newLabel() {
        return null;
    }

    @Override
    public void assignLabel(String label) {
    }

    @Override
    public byte loadValue(Attrib attr) throws YAPLException {
        return 0;
    }

    @Override
    public byte loadAddress(Attrib attr) throws YAPLException {
        return 0;
    }

    @Override
    public void freeReg(Attrib attr) {

    }

    @Override
    public void allocVariable(Symbol sym) throws YAPLException {

    }

    @Override
    public void setFieldOffsets(RecordType record) {

    }

    @Override
    public void storeArrayDim(int dim, Attrib length) throws YAPLException {

    }

    @Override
    public Attrib allocArray(ArrayType arrayType) throws YAPLException {
        return null;
    }

    @Override
    public Attrib allocRecord(RecordType recordType) throws YAPLException {
        return null;
    }

    @Override
    public void setParamOffset(Symbol sym, int pos) {

    }

    @Override
    public void arrayOffset(Attrib arr, Attrib index) throws YAPLException {

    }

    @Override
    public void recordOffset(Attrib record, Symbol field) throws YAPLException {

    }

    @Override
    public Attrib arrayLength(Attrib arr) throws YAPLException {
        return null;
    }

    @Override
    public void assign(Attrib lvalue, Attrib expr) throws YAPLException {

    }

    @Override
    public Attrib op1(Token op, Attrib x) throws YAPLException {
        return null;
    }

    @Override
    public Attrib op2(Attrib x, Token op, Attrib y) throws YAPLException {
        return null;
    }

    @Override
    public Attrib relOp(Attrib x, Token op, Attrib y) throws YAPLException {
        return null;
    }

    @Override
    public Attrib equalOp(Attrib x, Token op, Attrib y) throws YAPLException {
        return null;
    }

    @Override
    public void enterProc(Symbol proc) throws YAPLException {

    }

    @Override
    public void exitProc(Symbol proc) throws YAPLException {

    }

    @Override
    public void returnFromProc(Symbol proc, Attrib returnVal) throws YAPLException {

    }

    @Override
    public Attrib callProc(Symbol proc, Attrib[] args) throws YAPLException {
        return null;
    }

    @Override
    public void writeString(String string) throws YAPLException {

    }

    @Override
    public void branchIfFalse(Attrib condition, String label) throws YAPLException {

    }

    @Override
    public void jump(String label) {

    }
}
