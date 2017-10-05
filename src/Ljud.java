import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import java.io.File;

public class Ljud {

	public static void main(String[] args){

		Sequencer sequencer;
		try{
// Get default sequencer.
			sequencer = MidiSystem.getSequencer();
			if (sequencer == null) {
				System.out.println("Error -- sequencer device is not supported.");
				System.exit(0);
			}
// Acquire resources and make operational.
			sequencer.open();
			File myMidiFile = new File("flourish.mid");
// Construct a Sequence object, and
// load it into my sequencer.
			Sequence mySeq = MidiSystem.getSequence(myMidiFile);
			sequencer.setSequence(mySeq);
			sequencer.start();
		}
		catch (Exception e) {
			System.out.println("fel: " + e);
		}
	}

}
