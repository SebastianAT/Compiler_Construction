package yapl.lib;

public class ArrayType extends Type {
    private Type element;
    private int dim;
    private Type subarray;

    public ArrayType(Type element, int dim) {
        this.element = element;
        this.dim = dim;
        if(dim>1){
            this.subarray = new ArrayType(element, dim-1);
        }
        else{
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
