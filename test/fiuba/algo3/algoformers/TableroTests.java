package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.Tablero;
import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Escuadron;

public class TableroTests{

	@Test
	public void test01TableroVacio() {
		Tablero tablero = new Tablero(20,20);

		Assert.assertTrue(tablero.estaDesierto());
	}

	@Test
	public void test02TieneCasilleros() {
		Tablero tablero = new Tablero(3,3);

		Assert.assertTrue(tablero.getAncho() > 2);
		Assert.assertTrue(tablero.getAlto() > 2);
	}

	@Test
	public void test03UbicarAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();
		AlgoFormer segundoAlgoFormer = new AlgoFormer();
		AlgoFormer tercerAlgoFormer = new AlgoFormer();
		AlgoFormer cuartoAlgoFormer = new AlgoFormer();
		AlgoFormer quintoAlgoFormer = new AlgoFormer();
		AlgoFormer sextoAlgoFormer = new AlgoFormer();

		//List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.algoFormers.add(primerAlgoFormer);
		escuadronUno.algoFormers.add(segundoAlgoFormer);
		escuadronUno.algoFormers.add(tercerAlgoFormer);

		//List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();
		Escuadron escuadronDos = new Escuadron();
		escuadronDos.algoFormers.add(cuartoAlgoFormer);
		escuadronDos.algoFormers.add(quintoAlgoFormer);
		escuadronDos.algoFormers.add(sextoAlgoFormer);

		Tablero tablero = new Tablero(20,20);
		Assert.assertTrue(tablero.estaDesierto());

		tablero.agregarEscuadron(escuadronUno);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.cantidadMiembrosEscuadron());
		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,1,1));
		Assert.assertTrue(tablero.existeAlgoFormer(segundoAlgoFormer,1,2));
		Assert.assertTrue(tablero.existeAlgoFormer(tercerAlgoFormer,2,1));

		tablero.agregarEscuadron(escuadronDos);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.cantidadMiembrosEscuadron() + escuadronDos.cantidadMiembrosEscuadron());
		int ancho = tablero.getAncho();
		int alto = tablero.getAlto();
		Assert.assertTrue(tablero.existeAlgoFormer(cuartoAlgoFormer,ancho,alto));
		Assert.assertTrue(tablero.existeAlgoFormer(quintoAlgoFormer,ancho,alto-1));
		Assert.assertTrue(tablero.existeAlgoFormer(sextoAlgoFormer,ancho-1,alto));
	}

//	@Test
//	public void test04MoverAlgoFormer() {
//		AlgoFormer primerAlgoFormer = new AlgoFormer();
//
//		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
//		escuadronUno.add(primerAlgoFormer);
//
//		Tablero tablero = new Tablero();
//		Assert.assertTrue(tablero.estaDesierto());
//
//		tablero.agregarEscuadron(escuadronUno);
//		Assert.assertFalse(tablero.estaDesierto());
//		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size());
//		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,1,1));
//
//		primerAlgoFormer.moverDerecha();
//		Assert.assertFalse(tablero.existeAlgoFormer(primerAlgoFormer,1,1));
//		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,5,1));
//	}
//
//	@Test
//	public void test05AtaqueAlgoFormer() {
//		AlgoFormer primerAlgoFormer = new AlgoFormer();
//		AlgoFormer segundoAlgoFormer = new AlgoFormer();
//
//		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
//		escuadronUno.add(primerAlgoFormer);
//
//		List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();
//		escuadronDos.add(segundoAlgoFormer);
//
//		Tablero tablero = new Tablero(3,3); //Tablero chico, test de ataque
//		Assert.assertTrue(tablero.estaDesierto());
//
//		tablero.agregarEscuadron(escuadronUno);
//		Assert.assertFalse(tablero.estaDesierto());
//		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size());
//		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,1,1));
//
//		tablero.agregarEscuadron(escuadronDos);
//		Assert.assertFalse(tablero.estaDesierto());
//		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size() + escuadronDos.size());
//		int ancho = tablero.ancho();
//		int alto = tablero.alto();
//		Assert.assertTrue(tablero.existeAlgoFormer(segundoAlgoFormer,ancho-1,alto-1));
//
//		Assert.assertTrue(segundoAlgoFormer.vida() == 500);
//		primerAlgoFormer.atacar();
//		Assert.assertTrue(segundoAlgoFormer.vida() == 450);
//	}
}
