package fiuba.algo3.tablero;

@SuppressWarnings("serial")
public class MovimientoFueraDeRangoException extends RuntimeException{
    MovimientoFueraDeRangoException(){super();}

    MovimientoFueraDeRangoException(String mensaje){
        super(mensaje);
    }
}
