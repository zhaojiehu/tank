package tank5.tank;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tankmusic implements Runnable{
    private File music = new File("d:/ulasr-nrpku.wav");
    private AudioInputStream am;
    private SourceDataLine ac;
    private int sumbebyread = 0;
    private byte[] bytes = new byte[320];

    @Override
    public void run() {
        try {
            am = AudioSystem.getAudioInputStream(music);
            AudioFormat af = am.getFormat();
            DataLine.Info line = new DataLine.Info(SourceDataLine.class,af);
            ac = (SourceDataLine) AudioSystem.getLine(line);
            ac.open(af);
            ac.start();
            while (sumbebyread != -1){
                sumbebyread = am.read(bytes,0,bytes.length);
                if(sumbebyread >= 0){
                    ac.write(bytes,0,bytes.length);
                }

            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            ac.drain();
            ac.close();
        }
    }
}
