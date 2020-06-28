package yapl.lib;

import yapl.exception.InvalidRecordFieldException;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends Type {
    String name;
    List<Type> fields = new ArrayList<Type>();
    List<String> fnames = new ArrayList<String>();

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
}
