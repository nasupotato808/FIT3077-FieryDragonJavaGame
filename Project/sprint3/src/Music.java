import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;

class Music {

    boolean stop = true;
    void playMusic(){
        try {
            File musicPath = new File("C:\\Users\\tming\\OneDrive\\Doc\\FIT 3077\\MA_Tuesday12pm_Team002\\Project\\sprint3\\src\\moskau.wav");
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (stop){
                    clip.stop();
                }
            }
            else{
                System.out.println("Couldn't find Music file");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}