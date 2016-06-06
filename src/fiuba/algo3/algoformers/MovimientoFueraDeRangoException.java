package fiuba.algo3.algoformers;

@SuppressWarnings("serial")
public class MovimientoFueraDeRangoException extends RuntimeException{
    MovimientoFueraDeRangoException(){super();}

    MovimientoFueraDeRangoException(String mensaje){
        super(mensaje);
    }
}
