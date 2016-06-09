package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.personajes.Frenzy;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.OptimusPrime;
import fiuba.algo3.algoformers.personajes.Ratchet;
import fiuba.algo3.tablero.*;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTests {

	@Test
	public void test01MovimientoNormalAlgoFormer(){
		Tablero tablero = new Tablero(100,100);
		OptimusPrime optimusPrime = new OptimusPrime();
		Posicion unaPosicion = new Posicion(50,50);
		Posicion posicionRelativa = new Posicion(2,1);

		tablero.agregarAlgoFormer(optimusPrime,unaPosicion);
		optimusPrime.mover(posicionRelativa);
		Assert.assertTrue(tablero.existeAlgoFormer(optimusPrime,52,51));
	}

	@Test(expected=CasilleroOcupadoException.class)
	public void test02MovimientoHaciaCasilleroOcupado(){
		Tablero tablero = new Tablero(200,200);
		Megatron megatron = new Megatron();
		OptimusPrime optimusPrime = new OptimusPrime();

		Posicion unaPosicion = new Posicion(50,50);
		Posicion otraPosicion = new Posicion(51,51);

		Posicion posRelativa = new Posicion(1,1);

		tablero.agregarAlgoFormer(megatron,unaPosicion);
		tablero.agregarAlgoFormer(optimusPrime,otraPosicion);

		//System.out.println("megatron = (" + tablero.getPosicion(megatron).getX() + "," + tablero.getPosicion(megatron).getY()+")\n");
		megatron.mover(posRelativa);
		}

	@Test
	public void test03AlgoFormerNoSeMueveHaciaCasilleroOcupado(){

		Tablero tablero = new Tablero(200,200);
		Megatron megatron = new Megatron();
		OptimusPrime optimusPrime = new OptimusPrime();

		Posicion unaPosicion = new Posicion(50,50);
		Posicion otraPosicion = new Posicion(51,51);
		Posicion posRelativa = new Posicion(1,1);

		tablero.agregarAlgoFormer(megatron,unaPosicion);
		tablero.agregarAlgoFormer(optimusPrime,otraPosicion);

		try {megatron.mover(posRelativa);} catch(Exception e){};

		Assert.assertTrue(tablero.existeAlgoFormer(megatron, 50, 50));//megatron no se movio.
	}

	@Test(expected=MovimientoFueraDeRangoException.class)
	public void test04MovimientoFueraDeRango(){
		Tablero tablero = new Tablero(100,100);
		Megatron megatron = new Megatron();
		Posicion unaPosicion = new Posicion(50,50);
		Posicion posicionRelativa = new Posicion(10,15);

		tablero.agregarAlgoFormer(megatron,unaPosicion);
		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));

		megatron.mover(posicionRelativa);

		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));//megatron no se movio.
	}

	@Test(expected=CasilleroNoExisteException.class)
	public void test05MovimientoFueraDelTablero(){
		Tablero tablero = new Tablero(100,100);
		Frenzy frenzy = new Frenzy();
		Posicion unaPosicion = new Posicion(99,5);
		Posicion posicionRelativa = new Posicion(2,1);

		tablero.agregarAlgoFormer(frenzy,unaPosicion);

		frenzy.mover(posicionRelativa);

		Assert.assertTrue(tablero.existeAlgoFormer(frenzy,98,5));
	}

	@Test
	public void test06MovimientoConPosicionesRelativasNegativas(){
		Tablero tablero = new Tablero(100,100);
		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();

		Posicion unaPosicion = new Posicion(50,50);
		Posicion posicionRelativa = new Posicion(-3,-1);

		tablero.agregarAlgoFormer(ratchet,unaPosicion);
		ratchet.mover(posicionRelativa);

		Assert.assertTrue(tablero.existeAlgoFormer(ratchet,47,49));
	}

}

