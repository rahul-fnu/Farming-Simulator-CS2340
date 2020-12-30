package farmui.models;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

public class Music {
    public static void playAudio() throws Exception {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        sequencer.open();
        File song = new File("src/farmui/Stal.mid");
        InputStream input = new BufferedInputStream(new FileInputStream(song));
        sequencer.setSequence(input);
        sequencer.start();
    }
}
