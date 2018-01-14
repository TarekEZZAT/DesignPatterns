package step2;

import step1.Shape;

/*
Step 2

Create concrete classes extending the above class.

Rectangle.java
*/
public class Rectangle extends Shape {

   public Rectangle(){
     type = "Rectangle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
