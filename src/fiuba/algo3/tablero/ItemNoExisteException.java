package fiuba.algo3.tablero;

public class ItemNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	ItemNoExisteException(){
		super();
	}
	
	ItemNoExisteException(String mensaje){
		super(mensaje);
	}	
}