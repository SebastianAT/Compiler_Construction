package yapl.lib;

public class Type {
    private boolean isReadonly;

    public boolean isCompatible(Type t){
        if(this instanceof ArrayType && t instanceof  ArrayType){
            return ((ArrayType)this).getSubarray().isCompatible(((ArrayType)t).getSubarray());
        }
        if(this instanceof RecordType && t instanceof RecordType){
            return ((RecordType)this).equalsRecord((RecordType)t);
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
