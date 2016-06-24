package fiuba.algo3.juegomvc;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.media.AudioClip;

public class SoundPlayer {
	
	private final static String bonusPath = "/bonus_collected.mp3";
	private final static String transformationPath ="/transformation.wav";
	private final static String antitransformationPath = "/antitransformation.wav";
	private final static String movimientoPath = "/movimiento.wav";
	private final static String casilleroOcupadoPath = "/casillero_ocupado.wav";
	private final static String ataquePath = "/explosion.mp3";
	
	public static enum enumSound{
		BONUS_SOUND,
		TRANSFORMATION_SOUND,
		ANTITRANSFORMATION_SOUND,
		ATAQUE_SOUND,
		MOVIMIENTO,
		CASILLERO_OCUPADO,
		WIN
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
			case ATAQUE_SOUND:
				str = ataquePath;
				break;
			case WIN:
				break;
			case MOVIMIENTO:
				str = movimientoPath;
				break;
			case CASILLERO_OCUPADO:
				str = casilleroOcupadoPath;
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

