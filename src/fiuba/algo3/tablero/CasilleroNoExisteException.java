package fiuba.algo3.tablero;

public class CasilleroNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	CasilleroNoExisteException(){
		super();
	}
	
	CasilleroNoExisteException(String mensaje){
		super(mensaje);
	}	
}