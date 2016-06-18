package fiuba.algo3.tablero;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTests {

	@Test
	public void testVerificarSparkEnCentroDelTablero(){
		Juego juego = new Juego();
		Tablero tablero = juego.getTablero();
		int anchoTablero = tablero.getAlto();
		int altoTablero = tablero.getAncho();
		Casillero casillero;

		int anchoMedio = anchoTablero/2;
		int altoMedio = altoTablero/2;

		//Dado que no se en que posicion aleatoria se inicializo la Spark debo buscar hasta encontrala

		casillero = tablero.getCasillero(anchoMedio, altoMedio);

		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio - 1, altoMedio);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio + 1, altoMedio);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio - 1, altoMedio - 1);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio - 1, altoMedio + 1);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio + 1, altoMedio - 1);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio + 1, altoMedio + 1);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio, altoMedio - 1);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		casillero = tablero.getCasillero(anchoMedio, altoMedio + 1);
		try{
			if(casillero.getContenido().esSpark()) return;
		}catch(ItemNoExisteException e){};

		// Si llego hasta aca la Spark no existe;
		Assert.fail();
	}

}
