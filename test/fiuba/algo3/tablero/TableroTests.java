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

	@Test
	public void test02bis_ExisteAlgoformer(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		Megatron megatron = new Megatron();
		tablero.agregarAlgoFormer(megatron,TABLERO_ANCHO - 1 ,TABLERO_ALTO - 1);
		tablero.existeAlgoFormer(megatron,TABLERO_ANCHO -1,TABLERO_ALTO-1);
	}
	
	@Test (expected = CasilleroOcupadoException.class)
	public void test03NoSePermiteSuperposicionDePersonajes(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		
		tablero.agregarAlgoFormer(new Megatron(), TABLERO_ANCHO - 1, TABLERO_ALTO - 1);
		tablero.agregarAlgoFormer(new Megatron(), TABLERO_ANCHO - 1, TABLERO_ALTO - 1);
	}

	@Test (expected = CasilleroNoExisteException.class)
	public void test05MovimientoNoSeVaDeLosLimitesDelTableroDerecha(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		Megatron megatron = new Megatron();
		
		tablero.agregarAlgoFormer(megatron,TABLERO_ANCHO - 1,0);
		megatron.moverArriba();
	}

	@Test (expected = CasilleroNoExisteException.class)
	public void test06MovimientoNoSeVaDeLosLimitesDelTableroIzquierda(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		Megatron megatron = new Megatron();
		
		tablero.agregarAlgoFormer(megatron,0,0);
		megatron.moverIzquierda();
	}
	
	@Test (expected = CasilleroNoExisteException.class)
	public void test07MovimientoNoSeVaDeLosLimitesDelTableroArriba(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		Megatron megatron = new Megatron();
		
		tablero.agregarAlgoFormer(megatron,0,0);
		megatron.moverArriba();
	}
	
	@Test (expected = CasilleroNoExisteException.class)
	public void test08MovimientoNoSeVaDeLosLimitesDelTableroAbajo(){
		Tablero tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		Megatron megatron = new Megatron();
		
		tablero.agregarAlgoFormer(megatron,0,TABLERO_ALTO - 1);
		megatron.moverAbajo();
	}
		
}
