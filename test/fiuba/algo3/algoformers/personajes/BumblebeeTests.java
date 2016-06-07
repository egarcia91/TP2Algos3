package fiuba.algo3.algoformers.personajes;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.personajes.Bumblebee;

public class BumblebeeTests {
	private int vidaHumanoide = 350;
	private int fuerzaAtaqueHumanoide = 40;
	private int distanciaAtaqueHumanoide = 1;
	private int velocidadHumanoide = 2;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 350;
	private int fuerzaAtaqueAlterno = 20;
	private int distanciaAtaqueAlterno = 3;
	private int velocidadAlterno = 5;
	private String unidadAlterno = "terrestre";

	@Test
	public void test01CrearBumblebee() {
		Bumblebee bumblebee = new Bumblebee();

		Assert.assertTrue(bumblebee.getNombre() == "Bumblebee");
	}

	@Test
	public void test02BumblebeeHumanoide() {
		Bumblebee bumblebee = new Bumblebee();
		Assert.assertTrue(bumblebee.getVida() == vidaHumanoide);
		Assert.assertTrue(bumblebee.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(bumblebee.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(bumblebee.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(bumblebee.getTipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03BumblebeeAlterno() {
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.transformarAlterno();
		Assert.assertTrue(bumblebee.getVida() == vidaAlterno);
		Assert.assertTrue(bumblebee.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(bumblebee.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(bumblebee.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(bumblebee.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04BumblebeeTransformHumanoideAlterno() {
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.transformarAlterno();
		Assert.assertTrue(bumblebee.getVida() == vidaAlterno);
		Assert.assertTrue(bumblebee.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(bumblebee.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(bumblebee.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(bumblebee.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05BumblebeeTransformAlternoHumanoide() {
		Bumblebee bumblebee = new Bumblebee();
		bumblebee.transformarAlterno();
		bumblebee.transformarHumanoide();
		Assert.assertTrue(bumblebee.getVida() == vidaHumanoide);
		Assert.assertTrue(bumblebee.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(bumblebee.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(bumblebee.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(bumblebee.getTipoUnidad() == unidadHumanoide);
	}
}
