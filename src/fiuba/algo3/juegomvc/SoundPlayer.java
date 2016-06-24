package fiuba.algo3.juegomvc;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {
	
	private final static String bonusPath = "\\src\\bonus_collected.mp3";
	private final static String transformationPath = "\\src\\transformation.wav";
	private final static String antitransformationPath = "\\src\\antitransformation.wav";
	public static enum enumSound{
		BONUS_SOUND,
		TRANSFORMATION_SOUND,
		ANTITRANSFORMATION_SOUND
	};		
	
	public void play(enumSound enumSound){
		String str = "";

		switch(enumSound){
			case BONUS_SOUND:
				str = bonusPath;
				break;
			case TRANSFORMATION_SOUND:
				str = transformationPath;
				break;
			case ANTITRANSFORMATION_SOUND:
				str = antitransformationPath;
				break;
			default:
				break;
		}
		
		
			AudioClip audioClip = new AudioClip(validURL(str));
			audioClip.play();
			
	}
	
	private String validURL(String str){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s + str);
		return file.toURI().toASCIIString();
	}
}	

