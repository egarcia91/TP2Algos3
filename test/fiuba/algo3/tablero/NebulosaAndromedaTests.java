package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tablero.NebulosaAndromeda;

public class NebulosaAndromedaTests {
	@Test
	public void test01CrearNebulosaAndromeda() {
		NebulosaAndromeda nebulosaAndromeda = new NebulosaAndromeda();

		Assert.assertTrue(nebulosaAndromeda.getNombre() == "NebulosaAndromeda");
	}

	@Test
	public void test02VelocidadNebulosaAndromeda() {
		NebulosaAndromeda nebulosaAndromeda = new NebulosaAndromeda();

		Assert.assertTrue(nebulosaAndromeda.getVelocidad() == 1);
	}

	@Test
	public void test03NebulosaAndromedaTienePenalizacion() {
		NebulosaAndromeda nebulosaAndromeda = new NebulosaAndromeda();

		Assert.assertTrue(nebulosaAndromeda.tienePenalizacion());

		Assert.assertTrue(nebulosaAndromeda.getPenalizacionTurnos() == 3);
	}

}
