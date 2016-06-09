package fiuba.algo3.tablero;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTests {
	
	private static final int TABLERO_ANCHO = 200;
	private static final int TABLERO_ALTO = 200;

	@Test
	public void testVerificarSparkEnCentroDelTablero(){
		Juego juego = new Juego();
		Tablero tablero = juego.getTablero();
		Casillero casillero;

		int anchoMedio = TABLERO_ANCHO/2;
		int altoMedio = TABLERO_ALTO/2;
		
		//Dado que no se en que posicion aleatoria se inicializo la Spark debo buscar hasta encontrala
		
		casillero = tablero.getCasillero(anchoMedio, altoMedio);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};	
		
		casillero = tablero.getCasillero(anchoMedio - 1, altoMedio);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};	
		
		casillero = tablero.getCasillero(anchoMedio + 1, altoMedio);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};	
		
		casillero = tablero.getCasillero(anchoMedio - 1, altoMedio - 1);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};
		
		casillero = tablero.getCasillero(anchoMedio - 1, altoMedio + 1);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};
		
		casillero = tablero.getCasillero(anchoMedio + 1, altoMedio - 1);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};
		
		casillero = tablero.getCasillero(anchoMedio + 1, altoMedio + 1);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};	
		
		casillero = tablero.getCasillero(anchoMedio, altoMedio - 1);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};	
		
		casillero = tablero.getCasillero(anchoMedio, altoMedio + 1);
		try{
			if(casillero.getItem().getClass() == Spark.class) return;
		}catch(ItemNoExisteException e){};
		
		// Si llego hasta aca la Spark no existe;
		Assert.fail();
	}	

}
