package fiuba.algo3.algoformer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//import fiuba.algo3.algoformer.Tablero;
//import fiuba.algo3.algoformer.Casillero;
//import fiuba.algo3.algoformer.AlgoFormer;
//import fiuba.algo3.algoformer.Spark;

public class TableroTests {

	@Test
	public void test01TableroVacio() {
		Tablero tablero = new Tablero();

		Assert.assertTrue(tablero.estaDesierto());
	}

	@Test
	public void test02TieneCasilleros() {
		Tablero tablero = new Tablero();

		Assert.assertTrue(tablero.espacio() > 8);
		Assert.assertTrue(tablero.ancho() > 2);
		Assert.assertTrue(tablero.alto() > 2);
	}

	@Test
	public void test03UbicarAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();
		AlgoFormer segundoAlgoFormer = new AlgoFormer();
		AlgoFormer tercerAlgoFormer = new AlgoFormer();
		AlgoFormer cuartoAlgoFormer = new AlgoFormer();
		AlgoFormer quintoAlgoFormer = new AlgoFormer();
		AlgoFormer sextoAlgoFormer = new AlgoFormer();

		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(primerAlgoFormer);
		escuadronUno.add(segundoAlgoFormer);
		escuadronUno.add(tercerAlgoFormer);

		List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();
		escuadronDos.add(cuartoAlgoFormer);
		escuadronDos.add(quintoAlgoFormer);
		escuadronDos.add(sextoAlgoFormer);

		Tablero tablero = new Tablero();
		Assert.assertTrue(tablero.estaDesierto());

		tablero.agregarEscuadron(escuadronUno);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size());
		Assert.assertTrue(tablero.existeAlgoFormer(1,1));
		Assert.assertTrue(tablero.existeAlgoFormer(1,2));
		Assert.assertTrue(tablero.existeAlgoFormer(2,1));

		tablero.agregarEscuadron(escuadronDos);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size() + escuadronDos.size());
		Assert.assertTrue(tablero.existeAlgoFormer(tablero.ancho()-1,tablero.alto()-1));
		Assert.assertTrue(tablero.existeAlgoFormer(tablero.ancho()-1,tablero.alto()-2));
		Assert.assertTrue(tablero.existeAlgoFormer(tablero.ancho()-2,tablero.alto()-1));
	}

	@Test
	public void test04MoverAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();
		AlgoFormer segundoAlgoFormer = new AlgoFormer();
		AlgoFormer tercerAlgoFormer = new AlgoFormer();

		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(primerAlgoFormer);
		escuadronUno.add(segundoAlgoFormer);
		escuadronUno.add(tercerAlgoFormer);

		Tablero tablero = new Tablero();
		Assert.assertTrue(tablero.estaDesierto());

		tablero.agregarEscuadron(escuadronUno);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size());
		Assert.assertTrue(tablero.existeAlgoFormer(1,1));
		Assert.assertTrue(tablero.existeAlgoFormer(1,2));
		Assert.assertTrue(tablero.existeAlgoFormer(2,1));

		primerAlgoFormer.moverDerecha();
		//TODO Que hacemo
	}
}
