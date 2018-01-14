package step2;

import step1.AdvancedMediaPlayer;

/*
Step 2

Create concrete classes implementing the AdvancedMediaPlayer interface.

Mp4Player.java
*/
public class Mp4Player implements AdvancedMediaPlayer{

   @Override
   public void playVlc(String fileName) {
      //do nothing
   }

   @Override
   public void playMp4(String fileName) {
      System.out.println("Playing mp4 file. Name: "+ fileName);		
   }
}