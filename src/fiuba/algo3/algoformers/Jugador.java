package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.Juego;

public class Jugador {

	private String nombre;
	protected Juego juego;
	//private List<AlgoFormer> escuadron = new ArrayList<AlgoFormer>();
	private Escuadron escuadron;

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public String getNombre(){
		return this.nombre;
	}

	/*public void asignarEscuadron(List<AlgoFormer> unEscuadron){
		this.escuadron.addAll(unEscuadron);
	}*/

	public void asignarEscuadron(Escuadron unEscuadron){
		this.escuadron.asignarEscuadron(unEscuadron);
	}

	/*public boolean existeEscuadron(){
		return (this.escuadron.size() != 0);
	}*/

	public boolean existeEscuadron(){
		return (this.escuadron.existeEscuadron());
	}

	/*public int cantidadAlgoFormer(){
		return this.escuadron.size();
	}*/

	public int cantidadAlgoFormer(){
		return this.escuadron.cantidadMiembrosEscuadron();
	}

	/*public boolean tieneAlgoFormerEnPosicion(int x, int y){
		for (AlgoFormer unAlgoFormer:
				this.escuadron){
			if (unAlgoFormer.estaEnPosicion(x,y)) {
				return true;
			}
		}
		return false;
	}*/

	public boolean tieneAlgoFormerEnPosicion(int x, int y){
		return (this.escuadron.estaAlgoformerEnPosicion( x, y));
	}




	public void moverAlgoFormer(){
		if(this.juego.esTurnoJugador(this)){
			this.juego.cambiarTurnoJugador();
			//BLA BLA;
		} else {
		}
	}



}
