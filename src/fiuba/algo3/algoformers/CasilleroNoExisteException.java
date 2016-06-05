package fiuba.algo3.algoformers;

@SuppressWarnings("serial")
public class CasilleroNoExisteException extends RuntimeException {
	CasilleroNoExisteException(){
		super();
	}
	
	CasilleroNoExisteException(String mensaje){
		super(mensaje);
	}	
}