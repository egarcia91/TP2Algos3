package fiuba.algo3.tablero;

//@SuppressWarnings("serial");
public class MovimientoFueraDeRangoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    MovimientoFueraDeRangoException(){
        super();
    }

    MovimientoFueraDeRangoException(String mensaje){
        super(mensaje);
    }
}
