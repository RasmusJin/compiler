import java.util.HashMap;
import java.util.Map.Entry;

class Environment {
    private final HashMap<String,Boolean> variableValues = new HashMap<>();

    public Environment() { }	
    public void setVariable(String name, Boolean value) {
	variableValues.put(name, value);
    }
    
    public Boolean getVariable(String name){

	Boolean value = variableValues.get(name); 

	return value;
    }
	public String toString() {
	String table = "";
	for (Entry<String,Boolean> entry : variableValues.entrySet()) {
	    table += entry.getKey() + "\t-> " + entry.getValue() + "\n";
	}

	return table;
    }   
}

