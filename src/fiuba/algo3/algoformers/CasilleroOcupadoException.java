package fiuba.algo3.algoformers;

public class CasilleroOcupadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	CasilleroOcupadoException(){
		super();
	}
	
	CasilleroOcupadoException(String mensaje){
		super(mensaje);
	}
}

