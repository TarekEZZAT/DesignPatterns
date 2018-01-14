package immutable_model_with_builder;


import java.util.HashMap;
 
 
public class ImmutableDataBuilder {
 
    public static void main(String[] args) {
         
        // Getting immutable class only with required parameters
        ImmutableData immutableData = new ImmutableData.ImmutableDataBuilder(1, "Henry").build();
         
        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("Job", "Programmer");
        hm.put("City", "Toulouse");
        
        // Getting immutable class with optional parameters
        ImmutableData immutableDataWOptions = new ImmutableData.ImmutableDataBuilder(2, "Peter")
                                                     .setCompany("Apple").setProperties(hm).build();
         
        //Testing immutability
        HashMap<String,String> hmWO = immutableDataWOptions.getProperties();
         
        //lets modify the Object passed as argument or get from the Object
        hmWO.put("test", "test");
        hm.put("test", "test");

        //check that immutable class properties are not changed
        //System.out.println(immutableData.getProperties());
        System.out.println(immutableData.toString());

        
        //check that immutable class properties are not changed
        //System.out.println(immutableDataWOptions.getProperties());
        System.out.println(immutableDataWOptions.toString());
    }
 
}