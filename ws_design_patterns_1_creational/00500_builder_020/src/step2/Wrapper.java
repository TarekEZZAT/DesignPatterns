package step2;

import step1.Packing;

/*
Step 2

Create concrete classes implementing the Packing interface.

Wrapper.java
*/
public class Wrapper implements Packing {

   @Override
   public String pack() {
      return "Wrapper";
   }
}

