package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Jugador;

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
