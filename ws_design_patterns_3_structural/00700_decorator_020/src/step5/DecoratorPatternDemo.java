package step5;

import step1.Shape;
import step2.Circle;
import step2.Rectangle;
import step4.RedShapeDecorator;

/*
Step 5

Use the RedShapeDecorator to decorate Shape objects.

DecoratorPatternDemo.java
*/
public class DecoratorPatternDemo {
   public static void main(String[] args) {

      Shape circle = new Circle();

      Shape redCircle = new RedShapeDecorator(new Circle());

      Shape redRectangle = new RedShapeDecorator(new Rectangle());
      System.out.println("Circle with normal border");
      circle.draw();

      System.out.println("\nCircle of red border");
      redCircle.draw();

      System.out.println("\nRectangle of red border");
      redRectangle.draw();
   }
}