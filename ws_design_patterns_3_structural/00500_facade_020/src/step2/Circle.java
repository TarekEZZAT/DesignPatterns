package step2;

import step1.Shape;
/*
Circle.java
*/
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}