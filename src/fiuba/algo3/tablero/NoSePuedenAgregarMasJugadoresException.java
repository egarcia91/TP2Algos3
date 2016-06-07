package fiuba.algo3.tablero;

public class NoSePuedenAgregarMasJugadoresException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	NoSePuedenAgregarMasJugadoresException(){
		super();
	}
	
	NoSePuedenAgregarMasJugadoresException(String mensaje){
		super(mensaje);
	}
}

