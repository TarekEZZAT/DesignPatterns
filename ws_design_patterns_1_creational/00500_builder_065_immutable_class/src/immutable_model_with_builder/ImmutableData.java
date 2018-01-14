package immutable_model_with_builder;


import java.util.HashMap;
 


/*
To create immutable class in java, you have to do following steps.

1-Declare the class as final so it can’t be extended.
2-Make all fields private so that direct access is not allowed.
3-Don’t provide setter methods for variables
4-Make all mutable fields final so that it’s value can be assigned only once.
5-Initialize all the fields via a constructor performing deep copy.
6*Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

Important Points

The immutable class should have only getter methods.
The immutable class will have a private constructor with Builder object as parameter that will be used to create the immutable class.
If the immutable class attributes are not immutable, for example HashMap, we should perform deep copy or cloning to avoid modification of its attributes.
Using Builder pattern is easy when number of optional attributes are more in the immutable class.
*/





public class ImmutableData {
     
    //required fields
    private int id;
    private String name;
     
    //optional fields
    private HashMap<String, String> properties;
    private String company;
     
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public HashMap<String, String> getProperties() {
        //return cloned object to avoid changing it by the client application
        return (HashMap<String, String>) properties.clone();
    }
 
    public String getCompany() {
        return company;
    }
 
    private ImmutableData(ImmutableDataBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.properties = builder.properties;
        this.company = builder.company;
    }
    
    public String toString(){
    	String s = "id : " + this.id + " name : "+ this.name + " company : "+ this.company + " properties : " + this.properties;
    	return "[" + s + "]";
    }

     
        //Builder class
    public static class ImmutableDataBuilder{
        //required fields
        private int id;
        private String name;
         
        //optional fields
        private HashMap<String, String> properties;
        private String company;
         
        public ImmutableDataBuilder(int i, String nm){
            this.id=i;
            this.name=nm;
        }
         
        @SuppressWarnings("unchecked")
		public ImmutableDataBuilder setProperties(HashMap<String,String> hm){
            this.properties = (HashMap<String, String>) hm.clone();
            return this;
        }
         
        public ImmutableDataBuilder setCompany(String comp){
            this.company = comp;
            return this;
        }
         
        public ImmutableData build(){
            return new ImmutableData(this);
        }
        
    }
}