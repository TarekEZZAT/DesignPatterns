package singleton.lab_020;

public class SubClassSingleton extends BaseSingleton {
	private SubClassSingleton() {
	}

	/*
	 * Must override instance, otherwise the compiler returns instance of
	 * BaseSingleton
	 */
	/*
	 * private static SubClassSingleton instance;
	 * 
	 * public static SubClassSingleton getInstance() { if (instance == null) {
	 * instance = new SubClassSingleton(); } return (SubClassSingleton)
	 * instance; }
	 */
	public void DoSomething() {
		someInt = 2;
		System.out.println("SubClassSingleton " + this.someInt);
	}

	// @Override
	public void NewFunction() {
		// new functionality here
		System.out.println("New Function");
	}
}