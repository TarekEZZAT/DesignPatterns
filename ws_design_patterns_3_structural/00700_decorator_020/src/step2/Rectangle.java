package step2;

import step1.Shape;

/*
Step 2

Create concrete classes implementing the same interface.

Rectangle.java
*/
public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}
