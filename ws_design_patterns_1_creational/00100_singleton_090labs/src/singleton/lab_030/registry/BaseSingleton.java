package singleton.lab_030.registry;

import java.util.HashMap;


public class BaseSingleton
{
    protected BaseSingleton() { }

    @SuppressWarnings("rawtypes")
	private static HashMap map = new HashMap();
	private static  Object object = null;

	@SuppressWarnings("unchecked")
	public static BaseSingleton getInstance(String classname) {
		// First, attempt to get Singleton from HashMap
		Object object = (BaseSingleton) map.get(classname);

		if (object != null) {
			return (BaseSingleton) object;
		} 
		else {
			// Singleton not found
			if (classname.equals("BaseSingleton")) {
				object = new BaseSingleton();
				// Add singleton to HashMap so we can get it again
				map.put(classname, object);
				return (BaseSingleton) object;
			}

		}
		if (classname.equals("SubClassSingleton")) {
			object = new SubClassSingleton();
			// Add singleton to HashMap so we can get it again
			map.put(classname, object);
			return (SubClassSingleton) object;
		}

	
        else {/*......*/} 
		return null;
    }

    public void DoSomething() {
        
        System.out.println("BaseSingleton with Registry");
    }
}