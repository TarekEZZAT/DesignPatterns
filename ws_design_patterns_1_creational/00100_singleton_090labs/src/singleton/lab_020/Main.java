package singleton.lab_020;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseSingleton.getInstance().DoSomething();
		
		 //SubClassSingleton instance = (SubClassSingleton) SubClassSingleton.getInstance();
		 SubClassSingleton.getInstance();
		 //System.out.println(instance.getClass());
		 
		SubClassSingleton.getInstance().DoSomething();

		// ((SubClassSingleton) SubClassSingleton.getInstance()).NewFunction();
	}

}
