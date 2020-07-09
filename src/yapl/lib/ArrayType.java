package yapl.lib;

public class ArrayType extends Type {
    private Type element; //Elements of lowest level array (bottom level)
    private int dim;
    private Type subarray; //Elements of next lower level

    public ArrayType(Type type) {
        if(type instanceof ArrayType){
            this.element = ((ArrayType) type).getElement();
            this.dim = ((ArrayType) type).getDim()+1;
            this.subarray = type;
        }
        else{
            this.element = type;
            this.dim = 1;
            this.subarray = element;
        }
    }

    public Type getElement() {
        return element;
    }

    public void setElement(Type element) {
        this.element = element;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public Type getSubarray() {
        return subarray;
    }

    public void setSubarray(Type subarray) {
        this.subarray = subarray;
    }

    @Override
    public void setReadonly(boolean readonly) {
        element.setReadonly(readonly);
        subarray.setReadonly(readonly);
        super.setReadonly(readonly);
    }
}
