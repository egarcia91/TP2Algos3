package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Megatron;

public class MegatronTests {
	private int vidaHumanoide = 550;
	private int fuerzaAtaqueHumanoide = 10;
	private int distanciaAtaqueHumanoide = 3;
	private int velocidadHumanoide = 1;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 550;
	private int fuerzaAtaqueAlterno = 55;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 8;
	private String unidadAlterno = "aerea";

	@Test
	public void test01CrearMegatron() {
		Megatron megatron = new Megatron();

		Assert.assertTrue(megatron.getNombre() == "Megatron");
	}

	@Test
	public void test02MegatronHumanoide() {
		Megatron megatron = new Megatron();
		Assert.assertTrue(megatron.getVida() == vidaHumanoide);
		Assert.assertTrue(megatron.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(megatron.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(megatron.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(megatron.getTipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03MegatronAlterno() {
		Megatron megatron = new Megatron();
		megatron.transformarAlterno();
		Assert.assertTrue(megatron.getVida() == vidaAlterno);
		Assert.assertTrue(megatron.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(megatron.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(megatron.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(megatron.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04MegatronTransformHumanoideAlterno() {
		Megatron megatron = new Megatron();
		megatron.transformarAlterno();
		Assert.assertTrue(megatron.getVida() == vidaAlterno);
		Assert.assertTrue(megatron.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(megatron.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(megatron.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(megatron.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05MegatronTransformAlternoHumanoide() {
		Megatron megatron = new Megatron();
		megatron.transformarAlterno();
		megatron.transformarHumanoide();
		Assert.assertTrue(megatron.getVida() == vidaHumanoide);
		Assert.assertTrue(megatron.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(megatron.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(megatron.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(megatron.getTipoUnidad() == unidadHumanoide);
	}
}
