package step6;

import step4.ChickenBurger;
import step4.Coke;
import step4.Pepsi;
import step4.VegBurger;
import step5.Meal;

/*
Step 6

Create a MealBuilder class, the actual builder class responsible to create Meal objects.

MealBuilder.java
*/
public class MealBuilder {

   public Meal prepareVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new VegBurger());
      meal.addItem(new Coke());
      return meal;
   }   

   public Meal prepareNonVegMeal (){
      Meal meal = new Meal();
      meal.addItem(new ChickenBurger());
      meal.addItem(new Pepsi());
      return meal;
   }
}
