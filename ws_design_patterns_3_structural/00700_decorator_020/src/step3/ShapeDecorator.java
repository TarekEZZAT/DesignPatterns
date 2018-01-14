package step3;

import step1.Shape;

/*
Step 3

Create abstract decorator class implementing the Shape interface.

ShapeDecorator.java
*/
public abstract class ShapeDecorator implements Shape {
   protected Shape decoratedShape;

   public ShapeDecorator(Shape decoratedShape){
      this.decoratedShape = decoratedShape;
   }

   public void draw(){
      decoratedShape.draw();
   }	
}
