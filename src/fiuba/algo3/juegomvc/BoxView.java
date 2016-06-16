package fiuba.algo3.juegomvc;

import fiuba.algo3.juegomvc.modelo.Robot;
import fiuba.algo3.tablero.*;
import fiuba.algo3.algoformers.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class BoxView {

//	private final Robot robot;
	private final Tablero tablero;
	private AlgoFormer algoFormer;
	private final Juego juego;
	private int ancho;
	private int alto;
	private int pasoX;
	private int radioX;
	private int pasoY;
	GraphicsContext gc;

//	public BoxView(GraphicsContext gc, Robot robot){
//		this.gc = gc;
//		this.robot = robot;
//	}

	public BoxView(GraphicsContext gc, Juego juego){
		this.gc = gc;
		this.juego = juego;
		this.tablero = juego.getTablero();

		this.ancho = this.tablero.getAncho();
		this.alto = this.tablero.getAlto();
		this.pasoX = 600/this.ancho;
		this.radioX = this.pasoX/2;
		this.pasoY = 600/this.alto;
	}

	public void draw() {
		this.drawShapes(gc);
	}

	private void drawShapes(GraphicsContext gc) {
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		AlgoFormer algoFormerActual = jugadorTurnoActual.getSelectAlgoFormer();
		this.algoFormer = algoFormerActual;

		this.clean();
		gc.setFill(Color.GREEN);
		int cantAF = this.tablero.cantidadAlgoFormer();
//		for(int i = 0; i < cantAF; i++){
//			Posicion pos = this.tablero.getPosicion(this.escuadronAutoBot.getAlgoFormer(i));
//			gc.fillOval(this.pasoX*(pos.getX()-1)+this.radioX/2, this.pasoY*(pos.getY()-1)+this.radioX/2, this.radioX, this.radioX);
//		}

		gc.setFill(Color.WHITE);
		gc.fillText("Turno Jugador: "+ jugadorTurnoActual.getNombre(),20,20);
		if(jugadorTurnoActual.estaSeleccionadoAlgoFormer()){
			gc.fillText("AlgoFormer: "+ algoFormerActual.getNombre(),50,50);
//			gc.fillText("Seleccione Accion: "+ algoFormerActual.getNombre(),50,50);
		} else {
			gc.fillText("Seleccione AlgoFormer: "+ algoFormerActual.getNombre(),50,50);
		}

		//gc.setStroke(Color.BLUE);
		//gc.setLineWidth(5);
		//gc.strokeLine(40, 10, 10, 40);
		//gc.fillOval(10, 60, 30, 30);
		//gc.strokeOval(60, 60, 30, 30);
		//gc.fillRoundRect(110, 60, 30, 30, 10, 10);
		//gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
		//gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
		//gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
		//gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
		//gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
		//gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
		//gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
		//gc.fillPolygon(new double[]{10, 40, 10, 40},
		//new double[]{210, 210, 240, 240}, 4);
		//gc.strokePolygon(new double[]{60, 90, 60, 90},
		//new double[]{210, 210, 240, 240}, 4);
		//gc.strokePolyline(new double[]{110, 140, 110, 140},
		//new double[]{210, 210, 240, 240}, 4);
	}

	public void clean() {
		for(int i = 0; i < this.ancho; i++){
			for(int j = 0; j < this.alto; j++){
				this.gc.setFill(this.getColor(i+(this.alto*j)));
				this.gc.fillRect((this.pasoX*i), (this.pasoY*j), this.pasoX*(1+i), this.pasoY*(1+j));

//				Posicion posicion = new Posicion(i, j);
				Casillero casillero = this.tablero.getCasillero(i,j);
				if(casillero.contieneAlgoFormer()){
					AlgoFormer unAlgoFormer = casillero.getAlgoFormer();
					if(this.algoFormer == unAlgoFormer){
						this.gc.setFill(Color.BLUE);
					} else {
						this.gc.setFill(Color.GREEN);
					}
					this.gc.fillOval(this.pasoX*(i)+this.radioX/2, this.pasoY*(j)+this.radioX/2, this.radioX, this.radioX);
				}
				if(casillero.contieneItem()){
					this.gc.setFill(Color.WHITE);
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
}
