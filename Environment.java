import java.util.HashMap;
import java.util.Map.Entry;

class Environment {
	private final HashMap<String, String> idValues = new HashMap<>();
    private final HashMap<String,Boolean> variableValues = new HashMap<>();
    public Environment() { }	
    public void setVariable(String name, Boolean value) {
	variableValues.put(name, value);
    }
    
    public Boolean getVariable(String name){
	Boolean value = variableValues.get(name); 
	if (value == null) { System.err.println("Variable not defined: "+name); System.exit(-1); }
	return value;
    }
	public void setId(String id, String idInput){
		idValues.put(id, idInput);
	}
	public String getId(String id){
		String value = idValues.get(id);
		if (value == null) { System.err.println("Variable not defined: "+id); System.exit(-1); }
		return value;
	}
    
    public String toString() {
	String table = "";
	for (Entry<String,Boolean> entry : variableValues.entrySet()) {
	    table += entry.getKey() + "\t-> " + entry.getValue() + "\n";
	}
	for (Entry<String,String> entry : idValues.entrySet()) {
		table += entry.getKey() + "\t-> " + entry.getValue() + "\n";
	}
	return table;
    }   
}

