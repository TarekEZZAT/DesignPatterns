package step5;

import step2.GreenCircle;
import step2.RedCircle;
import step3.Shape;
import step4.Circle;
/*
Step 5

Use the Shape and DrawAPI classes to draw different colored circles.

BridgePatternDemo.java
*/
public class BridgePatternDemo {
   public static void main(String[] args) {
      Shape redCircle = new Circle(100,100, 10, new RedCircle());
      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
   }
}
