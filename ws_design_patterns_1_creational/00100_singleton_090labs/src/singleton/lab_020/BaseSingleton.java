package singleton.lab_020;

public class BaseSingleton {

//	private BaseSingleton() { }
	protected BaseSingleton() { }

//    private static BaseSingleton instance;
  private static BaseSingleton instance;
  protected static BaseSingleton getInstance()
    {
        if (instance == null) {
           instance = new BaseSingleton();
         }             
        return instance;
    }

    //Some state variables
    protected int someInt;
    
    //Function is marked as virtual so that it can be overidden
    public void DoSomething() {
        someInt = 1;
        System.out.println("BaseSingleton "+ this.someInt);
    }
}