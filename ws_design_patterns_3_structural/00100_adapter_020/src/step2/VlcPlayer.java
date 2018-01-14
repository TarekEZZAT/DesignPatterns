package step2;

import step1.AdvancedMediaPlayer;

/*
Step 2

Create concrete classes implementing the AdvancedMediaPlayer interface.

VlcPlayer.java
*/
public class VlcPlayer implements AdvancedMediaPlayer{
   @Override
   public void playVlc(String fileName) {
      System.out.println("Playing vlc file. Name: "+ fileName);		
   }

   @Override
   public void playMp4(String fileName) {
      //do nothing
   }
}
