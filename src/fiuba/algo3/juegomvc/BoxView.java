package fiuba.algo3.juegomvc;

import fiuba.algo3.juegomvc.modelo.Robot;
import fiuba.algo3.tablero.*;
import fiuba.algo3.algoformers.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.util.ArrayList;
import java.util.List;

public class BoxView {

	private final Tablero tablero;
	private AlgoFormer algoFormer;
	private final Juego juego;
	private Jugador jugador;
	private ArrayList<Casillero> posiblesMovimientos = new ArrayList<Casillero>();
	private int ancho;
	private int alto;
	private int pasoX;
	private int radioX;
	private int pasoY;
	GraphicsContext gc;

	public BoxView(GraphicsContext gc, Juego juego){
		this.gc = gc;
		this.juego = juego;
		this.tablero = juego.getTablero();

		this.ancho = this.tablero.getAncho();
		this.alto = this.tablero.getAlto();
		this.pasoX = 400/this.ancho;
		this.radioX = this.pasoX/2;
		this.pasoY = 400/this.alto;
	}

	public void draw() {
		this.drawShapes(gc);
	}

	private void drawShapes(GraphicsContext gc) {
		this.jugador = this.juego.getJugadorTurno();
		this.algoFormer = this.jugador.getSelectAlgoFormer();

//		if(this.jugador.estaSeleccionadoAlgoFormer()){
//			if(this.jugador.estaSeleccionadoAccion()){
//				//this.posiblesMovimientos = this.algoFormer.getMovimiento().posiblesMovimientos(this.algoFormer, this.algoFormer.getVelocidad());
//			}
//		}

		this.reDraw();

		this.gc.setFill(Color.WHITE);
		this.gc.fillRect(0, 400, 600, 600);
		this.gc.fillRect(400, 0, 600, 600);
		gc.setFill(Color.BLACK);

		gc.fillText("Turno Jugador: "+ this.jugador.getNombre(),20,420);
		if(this.jugador.estaSeleccionadoAlgoFormer()){
			if(!this.jugador.estaSeleccionadoAccion()){
				this.action();
			}
		} else {
		this.imprimirCaracteristicas(this.algoFormer);
		}
	}

	public void imprimirCaracteristicas(AlgoFormer unAlgoFormer){

		this.gc.fillText("Seleccione AlgoFormer: "+ unAlgoFormer.getNombre(),50,450);

		this.gc.fillText("--caracteristicas--",20,480);
		this.gc.fillText("vida: " + unAlgoFormer.getVida(),20,500);
		this.gc.fillText("velocidad: " + unAlgoFormer.getVelocidad(),20,515);
		this.gc.fillText("Distancia de ataque: " + unAlgoFormer.getDistanciaAtaque(),20,530);
		this.gc.fillText("Fuerza de ataque: " + unAlgoFormer.getFuerzaAtaque(),20,545);

		this.gc.fillText("---Estado---",160,480);
		if(unAlgoFormer.esHumanoide()){
			this.gc.fillText("Humanoide",160,500);
		} else {
			this.gc.fillText("Alterno",170,500);
		}

		this.gc.fillText("--Tipo de unidad--",260,480);
		if(unAlgoFormer.esTerrestre()){
			this.gc.fillText("Terrestre",260,500);
		} else {
			this.gc.fillText("Aereo",260,500);
		}
	}

	public void reDraw() {
		for(int i = 0; i < this.ancho; i++){
			for(int j = 0; j < this.alto; j++){
				Casillero casillero = this.tablero.getCasillero(i,j);
				if(this.jugador.posiblesMovimientos.contains(casillero)){
					this.gc.setFill(Color.WHITE);
				} else {
					this.gc.setFill(this.getColor(i+(this.alto*j)));
				}

				this.gc.fillRect((this.pasoX*i), (this.pasoY*j), this.pasoX*(1+i), this.pasoY*(1+j));

//				Posicion posicion = new Posicion(i, j);

				if(casillero.tieneContenido()){
					Contenido contenido = casillero.getContenido();
					//contenido.getClass();
					if(this.algoFormer == contenido){
						this.gc.setFill(Color.BLUE);
					} else {
						this.gc.setFill(Color.GREEN);
					}

					this.gc.fillOval(this.pasoX*(i)+this.radioX/2, this.pasoY*(j)+this.radioX/2, this.radioX, this.radioX);
				}
			}
		}
	}

	private Color getColor(int position) {

		int positionX = position%this.alto;
		int positionY = (position - positionX)/this.alto;

		if(positionX%2 == 0 && positionY%2 == 0 || positionX%2 == 1 && positionY%2 == 1){
			return Color.BLACK;
		} else {
			return Color.RED;
		}
	}

	public void update() {
		this.draw();
	}

	public void action() {
		this.gc.setFill(Color.BLACK);
		this.gc.fillText("AlgoFormer: "+ this.algoFormer.getNombre(),50,450);
		this.gc.fillText("Seleccione Accion: ",70,470);
		ArrayList<String> acciones = new ArrayList<String>();
		acciones.add("Atacar");
		acciones.add("Mover");
		acciones.add("Transformar");

		int indexSelecAction = this.jugador.getSelectAccion();
		String selectAction = acciones.get(indexSelecAction);
		acciones.set(indexSelecAction, "> ".concat(selectAction));
		this.gc.fillText(acciones.get(0),10,490);
		this.gc.fillText(acciones.get(1),90,490);
		this.gc.fillText(acciones.get(2),220,490);
	}
}
