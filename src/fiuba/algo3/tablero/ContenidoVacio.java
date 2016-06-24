package fiuba.algo3.tablero;

public class ContenidoVacio implements Contenido{

	@Override
	public boolean estaVacio(){
		return true;
	}

	@Override
	public boolean esAlgoFormer(){
		return false;
	}
	
	@Override
	public boolean esSpark(){
		return false;
	}

	@Override
	public boolean esBonus() {
		return false;
	}
}
