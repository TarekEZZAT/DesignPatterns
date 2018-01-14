package singleton.lab_030.registry;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BaseSingleton.getInstance(String classname).DoSomething();
		BaseSingleton instance1 = (BaseSingleton) BaseSingleton.getInstance("BaseSingleton");
		BaseSingleton.getInstance("BaseSingleton");
		 System.out.println(instance1.getClass());
			BaseSingleton.getInstance("BaseSingleton").DoSomething();

		
		
		 SubClassSingleton instance2 = (SubClassSingleton) SubClassSingleton.getInstance("SubClassSingleton");
		 SubClassSingleton.getInstance("SubClassSingleton");
		 System.out.println(instance2.getClass());
		 
		SubClassSingleton.getInstance("SubClassSingleton").DoSomething();

		// ((SubClassSingleton) SubClassSingleton.getInstance()).NewFunction();
	}

}
