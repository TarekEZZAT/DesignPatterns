package step3;

import step1.Image;
/*
Step 3

Use the ProxyImage to get object of RealImage class when required.

ProxyPatternDemo.java
*/
public class ProxyPatternDemo {
	
   public static void main(String[] args) {
      Image image = new ProxyImage("test_10mb.jpg");

      //image will be loaded from disk
      image.display(); 
      System.out.println("");
      
      //image will not be loaded from disk
      image.display(); 	
   }
}