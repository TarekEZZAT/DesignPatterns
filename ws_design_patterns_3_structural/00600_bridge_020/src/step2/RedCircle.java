package step2;

import step1.DrawAPI;

/*
Step 2

Create concrete bridge implementer classes implementing the DrawAPI interface.

RedCircle.java
*/
public class RedCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
   }
}

