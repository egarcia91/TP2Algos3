package fiuba.algo3.tablero;

public class AlgoFormerNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	AlgoFormerNoExisteException(){
		super();
	}
	
	AlgoFormerNoExisteException(String mensaje){
		super(mensaje);
	}	
}
