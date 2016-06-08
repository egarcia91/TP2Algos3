package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.OptimusPrime;
import fiuba.algo3.tablero.*;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTests {

	@Test
	public void test01MovimientoNormalDelAlgoFormer(){

		Tablero tablero = new Tablero(200,200);
		Megatron megatron = new Megatron();

		Posicion unaPosicion = new Posicion(20,20);
		tablero.agregarAlgoFormer(megatron,unaPosicion);

		Assert.assertTrue(tablero.existeAlgoFormer(megatron,20,20));

		Posicion posicionRelativa = new Posicion(1,1);

		megatron.mover(posicionRelativa);

		Assert.assertTrue(tablero.existeAlgoFormer(megatron,21,21));
		Assert.assertFalse(tablero.existeAlgoFormer(megatron,20,20));
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

		megatron.mover(posRelativa);

		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));//megatron no se movio.
	}


	@Test(expected=MovimientoFueraDeRangoException.class)
	public void testMovimientoFueraDeRango(){
		Tablero tablero = new Tablero(100,100);
		Megatron megatron = new Megatron();
		Posicion unaPosicion = new Posicion(50,50);
		Posicion posicionRelativa = new Posicion(10,15);

		tablero.agregarAlgoFormer(megatron,unaPosicion);
		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));

		megatron.mover(posicionRelativa);

		Assert.assertTrue(tablero.existeAlgoFormer(megatron,50,50));//megatron no se movio.
	}
}
