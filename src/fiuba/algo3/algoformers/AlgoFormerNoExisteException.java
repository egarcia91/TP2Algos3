package fiuba.algo3.algoformers;

@SuppressWarnings("serial")
public class AlgoFormerNoExisteException extends RuntimeException {
	AlgoFormerNoExisteException(){
		super();
	}
	
	AlgoFormerNoExisteException(String mensaje){
		super(mensaje);
	}	
}
