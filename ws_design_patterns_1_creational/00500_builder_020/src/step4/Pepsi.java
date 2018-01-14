package step4;

import step3.ColdDrink;
/*
Pepsi.java
*/
public class Pepsi extends ColdDrink {

   @Override
   public float price() {
      return 35.0f;
   }

   @Override
   public String name() {
      return "Pepsi";
   }
}