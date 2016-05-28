package fiuba.algo3.algoformer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformer.Tablero;
//import fiuba.algo3.algoformer.Casillero;
import fiuba.algo3.algoformer.AlgoFormer;
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
		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,1,1));
		Assert.assertTrue(tablero.existeAlgoFormer(segundoAlgoFormer,1,2));
		Assert.assertTrue(tablero.existeAlgoFormer(tercerAlgoFormer,2,1));

		tablero.agregarEscuadron(escuadronDos);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size() + escuadronDos.size());
		int ancho = tablero.ancho();
		int alto = tablero.alto();
		Assert.assertTrue(tablero.existeAlgoFormer(cuartoAlgoFormer,ancho-1,alto-1));
		Assert.assertTrue(tablero.existeAlgoFormer(quintoAlgoFormer,ancho-1,alto-2));
		Assert.assertTrue(tablero.existeAlgoFormer(sextoAlgoFormer,ancho-2,alto-1));
	}

	@Test
	public void test04MoverAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();

		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(primerAlgoFormer);

		Tablero tablero = new Tablero();
		Assert.assertTrue(tablero.estaDesierto());

		tablero.agregarEscuadron(escuadronUno);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size());
		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,1,1));

		primerAlgoFormer.moverDerecha();
		Assert.assertFalse(tablero.existeAlgoFormer(primerAlgoFormer,1,1));
		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,5,1));
	}

	@Test
	public void test05AtaqueAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();
		AlgoFormer segundoAlgoFormer = new AlgoFormer();

		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(primerAlgoFormer);

		List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();
		escuadronDos.add(segundoAlgoFormer);

		Tablero tablero = new Tablero(3,3); //Tablero chico, test de ataque
		Assert.assertTrue(tablero.estaDesierto());

		tablero.agregarEscuadron(escuadronUno);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size());
		Assert.assertTrue(tablero.existeAlgoFormer(primerAlgoFormer,1,1));

		tablero.agregarEscuadron(escuadronDos);
		Assert.assertFalse(tablero.estaDesierto());
		Assert.assertTrue(tablero.cantidadAlgoFormer() == escuadronUno.size() + escuadronDos.size());
		int ancho = tablero.ancho();
		int alto = tablero.alto();
		Assert.assertTrue(tablero.existeAlgoFormer(segundoAlgoFormer,ancho-1,alto-1));

		Assert.assertTrue(segundoAlgoFormer.vida() == 500);
		primerAlgoFormer.atacar();
		Assert.assertTrue(segundoAlgoFormer.vida() == 450);
	}
}
