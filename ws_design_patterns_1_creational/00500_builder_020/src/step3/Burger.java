package step3;

import step1.Item;
import step1.Packing;
import step2.Wrapper;

/*
Step 3

Create abstract classes implementing the item interface providing default functionalities.

Burger.java
*/
public abstract class Burger implements Item {

   @Override
   public Packing packing() {
      return new Wrapper();
   }

   @Override
   public abstract float price();
}
