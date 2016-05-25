package fiuba.algo3.algoformer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//import fiuba.algo3.modelo.Calendario;
//import fiuba.algo3.modelo.RecursoOcupadoException;

public class AlgoFormerPrimerTests {

	@Test
	public void test01verificarMovimiento() {
		Tablero tab = new Tablero();

		Assert.assertTrue(tab.cantidadCasilleros() == 80);

		AlgoFormer algoFormer = new AlgoFormer();

		tab.addAlgoFormer(algoFormer,1,1);

		Assert.assertTrue(tab.existeAlgoFormer(algoFormer));

		Assert.assertTrue(algoFormer.posicionY() == 1);
		Assert.assertTrue(algoFormer.posicionX() == 1);

		algoFormer.moverDerecha();
		Assert.assertTrue(algoFormer.posicionY() == 1);
		Assert.assertTrue(algoFormer.posicionX() == 5);
	}
	
//	@Test
//	public void test02agregarEventoSimple() {
//		
//		Calendario cal = new Calendario();
//		cal.agregarPersona("Juan");
//
//		List<String> invitados = new ArrayList<String>();
//		
//		invitados.add("Juan");
//		
//		cal.agregarEvento("Estudiar algebra", invitados, 2016, 5, 4, 10); // nombre evento, anio, mes, dia
//		
//		Assert.assertTrue(cal.estaOcupado("Juan", 2016, 5, 4, 10));
//		
//		Assert.assertFalse(cal.estaOcupado("Juan", 2016, 5, 4, 11));
//				
//	}
//	
//	
//	@Test
//	public void test03agregarEventoSemanal() {
//		
//		List<String> invitados = new ArrayList<>();
//		invitados.add("juan");
//
//		Calendario cal = new Calendario();
//		cal.agregarPersona("juan");
//		
//		cal.agregarEventoSemanal("Clase Algebra", 3, invitados, 2016, 5, 4, 10);
//		
//		// ocupado por 3 semanas
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 11, 10));
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 18, 10));
//		// desocupado la cuarta semana
//		Assert.assertFalse(cal.estaOcupado("juan", 2016, 5, 25, 10));
//	}
//	
//	@Test
//	public void test04agregarEventoConMasInvitados() {
//
//		List<String> invitados = new ArrayList<>();
//		invitados.add("juan");
//		invitados.add("pedro");
//
//		Calendario cal = new Calendario();
//		cal.agregarPersona("juan");
//		cal.agregarPersona("pedro");
//		cal.agregarPersona("maria");
//
//		cal.agregarEvento("Estudiar Algebra", invitados, 2016, 5, 4, 10);
//		
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
//		Assert.assertTrue(cal.estaOcupado("pedro", 2016, 5, 4, 10));
//		Assert.assertFalse(cal.estaOcupado("maria", 2016, 5, 4, 10));
//	}
//	
//	@Test
//	public void test05agregarRecursos() {
//		
//		Calendario cal = new Calendario();
//				
//		cal.agregarPersona("juan");
//		cal.agregarRecurso("proyector");
//
//		Assert.assertTrue(cal.existePersona("juan"));
//		Assert.assertTrue(cal.existeRecurso("proyector"));
//		Assert.assertFalse(cal.existeRecurso("juan"));
//		Assert.assertFalse(cal.existePersona("proyector"));
//	}
//	
//	@Test
//	public void test06agregarEventoConRecurso() {
//
//		List<String> invitados = new ArrayList<>();
//		invitados.add("juan");
//		invitados.add("proyector");
//
//		Calendario cal = new Calendario();
//		cal.agregarPersona("juan");
//		cal.agregarRecurso("proyector");
//
//		cal.agregarEvento("Exposicion TP", invitados, 2016, 5, 4, 10);
//
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
//		Assert.assertTrue(cal.estaOcupado("proyector", 2016, 5, 4, 10));
//	}
//	
//	@Test
//	public void test07PersonaSuperponeEventos() {
//		
//		List<String> invitados = new ArrayList<>();
//		invitados.add("juan");
//
//		Calendario cal = new Calendario();
//		cal.agregarPersona("juan");
//		
//		cal.agregarEvento("Estudiar Algebra", invitados, 2016, 5, 4, 10);
//		
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
//		
//		cal.agregarEvento("Mirar Partido", invitados, 2016, 5, 4, 10);
//		
//		Assert.assertTrue(cal.estaOcupado("juan", 2016, 5, 4, 10));
//	}
//
//	@Test(expected=RecursoOcupadoException.class)
//	public void test08recursoNoAdmiteSuperposicion() {
//
//		List<String> invitados = new ArrayList<>();
//		invitados.add("juan");
//		invitados.add("proyector");
//
//		Calendario cal = new Calendario();
//		cal.agregarPersona("juan");
//		cal.agregarRecurso("proyector");
//
//		cal.agregarEventoSemanal("Exposicion TP", 2, invitados, 2016, 5, 4, 10);
//		
//		Assert.assertTrue(cal.estaOcupado("proyector", 2016, 5, 11, 10));
//
//		cal.agregarEvento("Clase Teorica", invitados, 2016, 5, 11, 10);
//	}

}
