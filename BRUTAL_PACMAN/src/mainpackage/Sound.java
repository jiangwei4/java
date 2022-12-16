package mainpackage;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

@SuppressWarnings("unused")
public class Sound
{
    private AudioInputStream inputStream;
    private Clip clip;
    private boolean jouerDepuisLeDebut;
    private FloatControl volume;
    
    public Sound(final AudioInputStream a, final Clip b) {
        this.jouerDepuisLeDebut = true;
        this.inputStream = a;
        this.clip = b;
    }
    
    public boolean isOpen() {
        return this.clip.isOpen();
    }
    
    public void close() {
        this.clip.close();
    }
    
    public void initialiserAZero() {
        this.clip.setFramePosition(0);
    }
    
    public void lecture() {
        if (!this.clip.isOpen()) {
            try {
                this.clip.open(this.inputStream);
                this.volume = (FloatControl)this.clip.getControl(FloatControl.Type.MASTER_GAIN);
            }
            catch (Exception ex) {}
        }
    }
    
    public void jouer() {
        this.lecture();
        try {
            this.clip.start();
        }
        catch (Exception ex) {}
    }
    
    public void jouerEnBoucle() {
        this.lecture();
        this.clip.loop(-1);
    }
    
    public void stop() {
        if (this.clip.isOpen()) {
            this.clip.stop();
        }
    }
    
    public AudioInputStream getInputStream() {
        return this.inputStream;
    }
    
    public void setInputStream(final AudioInputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    public Clip getClip() {
        return this.clip;
    }
    
    public void setClip(final Clip clip) {
        this.clip = clip;
    }
    
    public boolean isJouerDepuisLeDebut() {
        return this.jouerDepuisLeDebut;
    }
    
    public void setJouerDepuisLeDebut(final boolean jouerDepuisLeDebut) {
        this.jouerDepuisLeDebut = jouerDepuisLeDebut;
    }
    
    public Float getVolume() {
        return this.volume.getValue();
    }
    
    public void setVolume(final float volume) {
        this.volume.setValue(volume);
    }
}