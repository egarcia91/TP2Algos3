package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.personajes.Frenzy;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.OptimusPrime;
import fiuba.algo3.algoformers.personajes.Ratchet;
import fiuba.algo3.tablero.*;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTests {
	private final static int TABLERO_ANCHO = 10;
	private final static int TABLERO_ALTO = 10;

	@Test
	public void test01MovimientoNormalAlgoFormer(){
		Tablero tablero = new Tablero(10,10);
		OptimusPrime optimusPrime = new OptimusPrime();

		tablero.agregarAlgoFormer(optimusPrime,new Posicion(5,5));
		optimusPrime.moverDerecha();
		Assert.assertTrue(tablero.existeAlgoFormer(optimusPrime,7,5));
	}

	@Test(expected=CasilleroOcupadoException.class)
	public void test02MovimientoHaciaCasilleroOcupado(){
		Tablero tablero = new Tablero(20,20);
		
		Megatron megatron = new Megatron();
		OptimusPrime optimusPrime = new OptimusPrime();
		tablero.agregarAlgoFormer(megatron,new Posicion(9,10));
		tablero.agregarAlgoFormer(optimusPrime,new Posicion(9+optimusPrime.getVelocidad(),10));
		megatron.moverDerecha();
		}

	@Test
	public void test03AlgoFormerNoSeMueveHaciaCasilleroOcupado(){

		Tablero tablero = new Tablero(200,200);
		Megatron megatron = new Megatron();
		OptimusPrime optimusPrime = new OptimusPrime();

		Posicion unaPosicion = new Posicion(50,50);
		Posicion otraPosicion = new Posicion(51,50);

		tablero.agregarAlgoFormer(megatron,unaPosicion);
		tablero.agregarAlgoFormer(optimusPrime,otraPosicion);

		try {megatron.moverDerecha();} catch(Exception e){};

		Assert.assertTrue(tablero.existeAlgoFormer(megatron, 50, 50));//megatron no se movio.
	}

	//@Test(expected=MovimientoFueraDeRangoException.class)
	@Test
	public void test04MovimientoFueraDeRango(){
//		Tablero tablero = new Tablero(100,100);
//		Megatron megatron = new Megatron();
//		Posicion unaPosicion = new Posicion(50,50);
//		Posicion posicionRelativa = new Posicion(10,15);
//
//		tablero.agregarAlgoFormer(megatron,unaPosicion);
//		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));
//
//		//megatron.mover(posicionRelativa);
//		megatron.moverDerecha();
//
//		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));//megatron no se movio.
	}

	@Test(expected=CasilleroNoExisteException.class)
	public void test05MovimientoFueraDelTablero(){
		Tablero tablero = new Tablero(100,100);
		Frenzy frenzy = new Frenzy();
		Posicion unaPosicion = new Posicion(99,5);
		Posicion posicionRelativa = new Posicion(2,1);

		tablero.agregarAlgoFormer(frenzy,unaPosicion);

		//frenzy.mover(posicionRelativa);
		frenzy.moverDerecha();

		Assert.assertTrue(tablero.existeAlgoFormer(frenzy,98,5));
	}

	@Test
	public void test06MovimientoConPosicionesRelativasNegativas(){
		Tablero tablero = new Tablero(100,100);
		Ratchet ratchet = new Ratchet();
//		ratchet.transformarAlterno();

		Posicion unaPosicion = new Posicion(50,50);

		tablero.agregarAlgoFormer(ratchet,unaPosicion);
		//ratchet.mover(posicionRelativa);
		ratchet.moverDerecha();

		//Assert.assertTrue(tablero.existeAlgoFormer(ratchet,51,50));
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

