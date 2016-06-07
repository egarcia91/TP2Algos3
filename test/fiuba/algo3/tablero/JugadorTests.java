package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.tablero.Jugador;

public class JugadorTests {

	@Test
	public void test01CrearJugador() {
		Jugador jugador = new Jugador("Eze");
		Assert.assertTrue(jugador.getNombre() == "Eze");
	}

	@Test
	public void test02AgregarAlgoFormer() {
		AlgoFormer primerAlgoFormer = new AlgoFormer();
		AlgoFormer segundoAlgoFormer = new AlgoFormer();
		AlgoFormer tercerAlgoFormer = new AlgoFormer();

		//List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.algoFormers.add(primerAlgoFormer);
		escuadronUno.algoFormers.add(segundoAlgoFormer);
		escuadronUno.algoFormers.add(tercerAlgoFormer);


		Jugador jugador = new Jugador("Jere");
		jugador.asignarEscuadron(escuadronUno);

		Assert.assertTrue(jugador.getNombre() == "Jere");
		Assert.assertTrue(jugador.cantidadAlgoFormer() == escuadronUno.cantidadMiembrosEscuadron());

	}
}
