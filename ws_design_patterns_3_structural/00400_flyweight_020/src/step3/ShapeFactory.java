package step3;
/*
Step 3

Create a factory to generate object of concrete class based on given information.
*/

import java.util.HashMap;

import step1.Shape;
import step2.Circle;

public class ShapeFactory {
   @SuppressWarnings("unchecked")
private static final HashMap<String, Shape> circleMap = new HashMap();

   public static Shape getCircle(String color) {
      Circle circle = (Circle)circleMap.get(color);

      if(circle == null) {
         circle = new Circle(color);
         circleMap.put(color, circle);
         System.out.println("Creating circle of color : " + color);
      }
      return circle;
   }
}