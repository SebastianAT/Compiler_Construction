package yapl.impl;

import yapl.compiler.Token;
import yapl.exception.IllegalEqualOpTypeException;
import yapl.exception.IllegalOp1TypeException;
import yapl.exception.IllegalOp2TypeException;
import yapl.exception.IllegalRelOpTypeException;
import yapl.interfaces.Attrib;
import yapl.interfaces.CodeGen;
import yapl.interfaces.Symbol;
import yapl.lib.*;

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
        if(op != null){
            if(!(x.getType() instanceof IntType)){
                throw new IllegalOp1TypeException(op);
            }
        }
        return x;
    }

    @Override
    public Attrib op2(Attrib x, Token op, Attrib y) throws YAPLException {
        if(!(x.getType().isCompatible(y.getType()))){
            throw new IllegalOp2TypeException(op);
        }
        return x;
    }

    @Override
    public Attrib relOp(Attrib x, Token op, Attrib y) throws YAPLException {
        if(!(x.getType() instanceof IntType && y.getType() instanceof IntType)){
            throw new IllegalRelOpTypeException(op);
        }
        return new YAPLAttrib(new BoolType());
    }

    @Override
    public Attrib equalOp(Attrib x, Token op, Attrib y) throws YAPLException {
        if(!(x.getType().isCompatible(y.getType()))){
            throw new IllegalEqualOpTypeException(op);
        }
        return new YAPLAttrib(new BoolType());
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
