package immutable_model_no_builder;

/*
To create immutable class in java, you have to do following steps.

1-Declare the class as final so it can’t be extended.
2-Make all fields private so that direct access is not allowed.
3-Don’t provide setter methods for variables
4-Make all mutable fields final so that it’s value can be assigned only once.
5-Initialize all the fields via a constructor performing deep copy.
6*Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
*/


import java.util.HashMap;
import java.util.Iterator;

/** Immutable class FinalData */
public final class ImmutableData {

	private final int id;
	
	private final String name;
	
	private final HashMap<String,String> testMap;
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	/**
	 * Accessor function for mutable objects
	 */
	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Constructor performing Deep Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	
	public ImmutableData(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=i;
		this.name=n;
		
		//***** Deep copy -----//
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap=tempMap;
	}
	
	
	/**
	 * Constructor performing Shallow Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	/**
	public FinalClassExample(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id=i;
		this.name=n;
		
		//***** Shallow copy -----//
		this.testMap=hm;
	}
	*/
	
	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int i=10;
		
		ImmutableData immutableData = new ImmutableData(i,s,h1);
		
		//Lets see whether its copy by field or reference
		System.out.println(s==immutableData.getName());
		System.out.println(h1 == immutableData.getTestMap());
		//print the ce values
		System.out.println("ImmutableData id:"+immutableData.getId());
		System.out.println("ImmutableData name:"+immutableData.getName());
		System.out.println("ImmutableData testMap:"+immutableData.getTestMap());
		//change the local variable values
		i=20;
		s="modified";
		h1.put("3", "third");
		//print the values again
		System.out.println("ImmutableData id after local variable change:"+immutableData.getId());
		System.out.println("ImmutableData name after local variable change:"+immutableData.getName());
		System.out.println("ImmutableData testMap after local variable change:"+immutableData.getTestMap());
		
		HashMap<String, String> hmTest = immutableData.getTestMap();
		hmTest.put("4", "new");
		
		System.out.println("ImmutableData testMap after changing variable from accessor methods:"+immutableData.getTestMap());

	}

}