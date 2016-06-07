package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.personajes.*;

public class TableroTests{
	
	private static final int TABLERO_ANCHO = 200;
	private static final int TABLERO_ALTO = 200;

	@Test
	public void test01verificarConstruccionDeCasilleros() {
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);

		for(int i = 0; i < TABLERO_ANCHO; i++){
			for(int j = 0; j< TABLERO_ALTO; j++){
				try{
					Assert.assertTrue(tablero.getCasillero(i,j).getClass() == Casillero.class);
				}
				catch(Exception e){
					System.err.println("Error en casillero posicion: (" + i + ',' + j + ')');
					throw e;
				}
			}
		}	
	}
	
	@Test
	public void test02TableroVacio(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		
		Assert.assertTrue(tablero.estaDesierto());
		
		tablero.agregarAlgoFormer(new Megatron(),TABLERO_ANCHO - 1 ,TABLERO_ALTO - 1);
		Assert.assertFalse(tablero.estaDesierto());
	}
	
	@Test (expected = CasilleroOcupadoException.class)
	public void test03NoSePermiteSuperposicionDePersonajes(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		
		tablero.agregarAlgoFormer(new Megatron(), TABLERO_ANCHO - 1, TABLERO_ALTO - 1);
		tablero.agregarAlgoFormer(new Megatron(), TABLERO_ANCHO - 1, TABLERO_ALTO - 1);
	}

	@Test
	public void test04MovimientoDeAlgoformers() {
		Tablero tablero = new Tablero(200,200);
		Megatron megatron = new Megatron();
		Posicion posicionActual = new Posicion(10,10);
		
		tablero.agregarAlgoFormer(megatron,posicionActual);
		
		posicionActual.sumar(3,4);
		tablero.moverAlgoFormer(megatron,3,4);
		Assert.assertTrue(tablero.getPosicion(megatron) == posicionActual);
		
		posicionActual.sumar(-3,10);
		tablero.moverAlgoFormer(megatron, -3,10);
		Assert.assertTrue(tablero.getPosicion(megatron) == posicionActual);
	}
	
	@Test (expected = CasilleroNoExisteException.class)
	public void test05MovimientoNoSeVaDeLosLimitesDelTablero(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		Megatron megatron = new Megatron();
		
		tablero.agregarAlgoFormer(megatron,TABLERO_ANCHO - 1,TABLERO_ALTO - 1);
		tablero.moverAlgoFormer(megatron,1,1);
	}
	
}
