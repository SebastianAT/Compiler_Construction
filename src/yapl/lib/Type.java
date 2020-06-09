package yapl.lib;

public class Type {
    private boolean isReadonly;

    public boolean isCompatible(Type t){
        if(this instanceof ArrayType && t instanceof  ArrayType){
            return ((ArrayType)this).getElement().isCompatible(((ArrayType)t).getElement());
        }
        return this.getClass().equals(t.getClass());
    }

    public boolean isReadonly() {
        return isReadonly;
    }

    public void setReadonly(boolean readonly) {
        isReadonly = readonly;
    }
}
