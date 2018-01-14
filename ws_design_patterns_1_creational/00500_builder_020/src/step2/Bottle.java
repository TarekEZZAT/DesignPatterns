package step2;

import step1.Packing;

/*
Bottle.java
*/
public class Bottle implements Packing {

   @Override
   public String pack() {
      return "Bottle";
   }
}