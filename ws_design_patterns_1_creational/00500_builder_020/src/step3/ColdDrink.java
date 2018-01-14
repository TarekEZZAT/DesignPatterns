package step3;

import step1.Item;
import step1.Packing;
import step2.Bottle;

/*
ColdDrink.java
*/
public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
       return new Bottle();
	}

	@Override
	public abstract float price();
}
