package game;

import javafx.scene.media.AudioClip;

import java.io.File;

public class VFXSound {
   private AudioClip fireClip;
   private AudioClip bombClip;
   private AudioClip background;
   VFXSound() throws Exception{
       fireClip = new AudioClip(String.valueOf(new File("sounds/fire.mp3").toURI().toURL()));
       bombClip = new AudioClip(String.valueOf(new File("sounds/bomb.mp3").toURI().toURL()));
       background = new AudioClip(String.valueOf(new File("sounds/backgroundMusic.wav").toURI().toURL()));
       background.play();
   }
   public void fireSound(){
       if (!fireClip.isPlaying()){
           fireClip.play();
       }
   }
   public void bombSound(){
       if (!bombClip.isPlaying()){
           bombClip.play();
       }
   }
   public void muteAll(){
       fireClip.setVolume(0.0);
       bombClip.setVolume(0.0);
   }
   public void unmuteAll(){
       fireClip.setVolume(1.0);
       bombClip.setVolume(1.0);
   }
   public void muteBgMusic(){
       background.stop();

   }
   public void unmuteBgMusic(){
       background.play();
   }
}
