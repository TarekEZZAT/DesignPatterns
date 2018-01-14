package singleton.lab_030.registry;


public class SubClassSingleton extends BaseSingleton {
	SubClassSingleton() {
	}

	public void DoSomething() {
		
		System.out.println("SubClassSingleton with registry");
	}

	// @Override
	public void NewFunction() {
		// new functionality here
		System.out.println("New Function");
	}
}