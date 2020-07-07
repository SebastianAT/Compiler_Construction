package yapl.impl;

import yapl.compiler.Token;
import yapl.compiler.Yapl;
import yapl.exception.*;
import yapl.interfaces.*;
import yapl.lib.*;

public class CodeGenImpl implements CodeGen {

    private BackendBinSM backend;
    private int nrLabels;

    public CodeGenImpl(BackendBinSM backend){
        this.backend = backend;
    }

    @Override
    public String newLabel() {
        nrLabels++;
        return "tLabel" + nrLabels;
    }

    @Override
    public void assignLabel(String label) {
        backend.assignLabel(label);
    }

    @Override
    public byte loadValue(Attrib attr) throws YAPLException {
        // TODO
        return 0;
    }

    @Override
    public byte loadAddress(Attrib attr) throws YAPLException {
        // TODO
        return 0;
    }

    @Override
    public void freeReg(Attrib attr) {
        // TODO
    }

    @Override
    public void allocVariable(Symbol sym) throws YAPLException {
        if(sym.isGlobal()){
            sym.setOffset(backend.allocStaticData(1));
        } else {
            sym.setOffset(backend.allocStack(1));
        }
    }

    @Override
    public void setFieldOffsets(RecordType record) {

    }

    @Override
    public void storeArrayDim(int dim, Attrib length) throws YAPLException {
        backend.storeArrayDim(dim);
    }

    @Override
    public Attrib allocArray(ArrayType arrayType) throws YAPLException {
        YAPLAttrib attrib = new YAPLAttrib(arrayType);
        attrib.setKind(Attrib.RegAddress);
        return attrib;
    }

    @Override
    public Attrib allocRecord(RecordType recordType) throws YAPLException {
        YAPLAttrib attrib = new YAPLAttrib(recordType);
        attrib.setKind(Attrib.RecordField);
        return attrib;
    }

    @Override
    public void setParamOffset(Symbol sym, int pos) {

    }

    @Override
    public void arrayOffset(Attrib arr, Attrib index) throws YAPLException {
        backend.loadWord(MemoryRegion.STACK, arr.getOffset());
    }

    @Override
    public void recordOffset(Attrib record, Symbol field) throws YAPLException {
        backend.loadWord(MemoryRegion.STACK, record.getOffset());
    }

    @Override
    public Attrib arrayLength(Attrib arr) throws YAPLException {
        backend.arrayLength();
        return new YAPLAttrib(new IntType());
    }

    @Override
    public void assign(Attrib lvalue, Attrib expr) throws YAPLException {
        if (!lvalue.getType().isCompatible(expr.getType()))
        {
            throw new TypeMismatchAssignException();
        }

        if(lvalue.getKind() != Attrib.ArrayElement){
            backend.storeWord(MemoryRegion.STACK, lvalue.getOffset());
        } else {
            backend.storeArrayElement();
        }
    }

    @Override
    public Attrib op1(Token op, Attrib x) throws YAPLException {
        if(op != null){
            if(!(x.getType() instanceof IntType)){
                throw new IllegalOp1TypeException(op);
            }

            if(op.image == "-"){
                backend.neg();
            }
        }
        return x;
    }

    @Override
    public Attrib op2(Attrib x, Token op, Attrib y) throws YAPLException {
        if(op.kind == Yapl.OR || op.kind == Yapl.AND ){
            if (!(x.getType() instanceof BoolType && y.getType() instanceof BoolType))
                throw new IllegalOp2TypeException(op);
        }
        if(!(x.getType().isCompatible(y.getType()))){
            throw new IllegalOp2TypeException(op);
        }

        if(op.image == "*"){
            backend.mul();
        } else if(op.image == "+"){
            backend.add();
        } else if(op.image == "-"){
            backend.sub();
        } else if(op.image == "%"){
            backend.mod();
        } else if(op.image == "/"){
            backend.div();
        }

        if(op.kind == Yapl.AND){
            backend.and();
        } else if(op.kind == Yapl.OR){
            backend.or();
        }
        return x;
    }

    @Override
    public Attrib relOp(Attrib x, Token op, Attrib y) throws YAPLException {
        if(!(x.getType() instanceof IntType && y.getType() instanceof IntType)){
            throw new IllegalRelOpTypeException(op);
        }

        if(op.image == ">"){
            backend.isGreater();
        } else if(op.image == "<"){
            backend.isLess();
        } else if(op.image == ">="){
            backend.isGreaterOrEqual();
        } else if(op.image == "<="){
            backend.isLessOrEqual();
        }
        return new YAPLAttrib(new BoolType());
    }

    @Override
    public Attrib equalOp(Attrib x, Token op, Attrib y) throws YAPLException {
        if(!(x.getType().isCompatible(y.getType()))){
            throw new IllegalEqualOpTypeException(op);
        }

        if(op.image == "=="){
            backend.isEqual();
        }
        // TODO not Equal?
        return new YAPLAttrib(new BoolType());
    }

    @Override
    public void enterProc(Symbol proc) throws YAPLException {
        backend.enterProc(proc.getName(), proc.getParam().size(), proc.isGlobal());
    }

    @Override
    public void exitProc(Symbol proc) throws YAPLException {
        backend.exitProc(proc.getName());
    }

    @Override
    public void returnFromProc(Symbol proc, Attrib returnVal) throws YAPLException {
        backend.jump(proc.getName() + "_end");
    }

    @Override
    public Attrib callProc(Symbol proc, Attrib[] args) throws YAPLException {
        backend.callProc(proc.getName());
        return new YAPLAttrib(proc.getType());
    }

    @Override
    public void writeString(String string) throws YAPLException {
        String temp = string.substring(1, string.length()-1);
        int addr = backend.allocStringConstant(temp);
        backend.writeString(addr);
    }

    @Override
    public void branchIfFalse(Attrib condition, String label) throws YAPLException {
        if(condition.getKind() == Attrib.Invalid){
            backend.branchIf(false, label);
        }
    }

    @Override
    public void jump(String label) {
        backend.jump(label);
    }
}
