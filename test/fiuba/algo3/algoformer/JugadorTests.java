package fiuba.algo3.algoformer;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformer.AlgoFormer;
import fiuba.algo3.algoformer.Jugador;
import fiuba.algo3.algoformer.Spark;

public class JugadorTests {

	@Test
	public void test01CrearJugador() {
		Jugador jugador = new Jugador();
		jugador.setNombre("Juan");

		Assert.assertTrue(jugador.getNombre() == "Juan");
	}

	@Test
	public void test02AgregarAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();
		AlgoFormer segundoAlgoFormer = new AlgoFormer();
		AlgoFormer tercerAlgoFormer = new AlgoFormer();

		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(primerAlgoFormer);
		escuadronUno.add(segundoAlgoFormer);
		escuadronUno.add(tercerAlgoFormer);


		Jugador jugador = new Jugador();
		jugador.setNombre("Juan");
		jugador.asignarEscuadron(escuadronUno);

		Assert.assertTrue(jugador.getNombre() == "Juan");
		Assert.assertTrue(jugador.cantidadAlgoFormer() == escuadronUno.size());

	}
}
