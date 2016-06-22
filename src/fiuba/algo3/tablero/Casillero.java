package fiuba.algo3.tablero;

public class Casillero {
	private Contenido contenido = new ContenidoVacio();

	private Terreno terrenoTerrestre = new Rocosa(); //Por defecto lleno de nada
	private Terreno terrenoAereo = new Nube(); //Por defecto lleno de nada

	public boolean noExiste(){
		return false;
	}

	public void agregarContenido(Contenido unContenido){
		if(this.tieneContenido() && unContenido.esAlgoFormer() && this.contenido.esAlgoFormer()){
			throw new CasilleroOcupadoException();
		}
		this.contenido = unContenido;
	}

	public Contenido getContenido(){
		return this.contenido;
	}

	public void quitarContenido(){
		this.contenido = new ContenidoVacio();
	}

	public boolean tieneContenido(){
		return !this.estaVacio();
	}

	public Terreno getTerrenoTerrestre(){
		return this.terrenoTerrestre;
	}

	public void setTerrenoTerrestre(Terreno unTerreno){
		this.terrenoTerrestre = unTerreno;
	}

	public Terreno getTerrenoAereo(){
		return this.terrenoAereo;
	}

	public void setTerrenoAereo(Terreno unTerreno){
		this.terrenoAereo = unTerreno;
	}

	public boolean estaVacio(){
		return this.contenido.estaVacio();
	}

}
