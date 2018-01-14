package step4;

import step3.ShapeMaker;

/*
Step 4

Use the facade to draw various types of shapes.

FacadePatternDemo.java
*/
public class FacadePatternDemo {
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();		
   }
}