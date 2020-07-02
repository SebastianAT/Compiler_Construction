package yapl.lib;

import yapl.exception.InvalidRecordFieldException;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends Type {
    private String name;
    private List<Type> fields = new ArrayList<Type>();
    private List<String> fnames = new ArrayList<String>();

    public RecordType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addField(Type type, String name){
        fields.add(type);
        fnames.add(name);
    }

    public List<Type> getFields() {
        return fields;
    }

    public List<String> getFnames() {
        return fnames;
    }

    public Type returnType(String name) throws YAPLException{
        int i = fnames.indexOf(name);
        if(i != -1){
            return fields.get(i);
        }
        throw new InvalidRecordFieldException(name, this.name);
    }

    public boolean equalsRecord(RecordType record){
        if(fields.size() != record.getFields().size())
            return false;
        for (int i = 0; i < fields.size(); i++) {
            if(!fields.get(i).equals(record.getFields().get(i))) {      //Lazy fix for recursive Recordtypes. Wont work with two recursive Types that are equal
                if (!fields.get(i).isCompatible(record.getFields().get(i))) {
                    return false;
                }
            }
            if(!fnames.get(i).equals(record.getFnames().get(i))){
                return false;
            }

        }
        return true;
    }
}
