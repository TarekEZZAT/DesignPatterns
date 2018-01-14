package step4;

import step3.Burger;

/*
Step 4

Create concrete classes extending Burger and ColdDrink classes

VegBurger.java
*/
public class VegBurger extends Burger {

   @Override
   public float price() {
      return 25.0f;
   }

   @Override
   public String name() {
      return "Veg Burger";
   }
}
