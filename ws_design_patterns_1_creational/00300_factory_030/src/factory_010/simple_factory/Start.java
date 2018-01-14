package factory_010.simple_factory;

public class Start {

	public static void main(String[] args) {
		Pizza pizza = null;
		// TODO Auto-generated method stub
		pizza = orderPizzaByName("veggie");
		standardOperations(pizza);
		pizza = orderPizzaByType("cheese");
		standardOperations(pizza);



	}

	public static Pizza orderPizzaByName(String pizzaName) {
		Pizza pizza = null;
		if (pizzaName.equalsIgnoreCase("clam")) {
		pizza = new CheesePizza();
		}
		if (pizzaName.equalsIgnoreCase("veggie")) {
		pizza = new VeggiePizza();
		}
		/* etc... */
		return pizza;

	}
		public static Pizza orderPizzaByType(String type) {
		SimplePizzaFactory spf = new SimplePizzaFactory();
		PizzaStore ps = new PizzaStore(spf);
		Pizza pizza = spf.createPizza("cheese");
		return pizza;
	}
		
		public static void standardOperations(Pizza pizza){
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
			System.out.println("+++++++++");
		}

}
