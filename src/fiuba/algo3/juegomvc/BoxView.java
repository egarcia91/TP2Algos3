package fiuba.algo3.juegomvc;

import fiuba.algo3.tablero.*;
import fiuba.algo3.algoformers.*;
import fiuba.algo3.algoformers.personajes.Megatron;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class BoxView {

	private final Tablero tablero;
	private AlgoFormer algoFormer;
	private final Juego juego;
	private Jugador jugador;
	private ArrayList<Casillero> posiblesMovimientos = new ArrayList<Casillero>();
	private int cantidadCasillerosX;
	private int cantidadCasillerosY;
	private int pixCasilleroAncho = 48;
	private int pixCasilleroAlto = 48;
	GraphicsContext gc;
	Group root;
	double sceneX;
	double sceneY;

	public BoxView(Group root,double sceneX,double sceneY,GraphicsContext gc, Juego juego){
		this.gc = gc;
		this.root = root;
		this.juego = juego;
		this.tablero = juego.getTablero();
		this.sceneX = sceneX;
		this.sceneY = sceneY;
		
		this.cantidadCasillerosX = this.tablero.getAncho();
		this.cantidadCasillerosY = this.tablero.getAlto();
	}

	public void update() {
		this.draw();
	}

	public void draw(){
		this.jugador = this.juego.getJugadorTurno();
		this.algoFormer = this.jugador.getSelectAlgoFormer();

		this.reDraw();

		if(this.jugador.estaSeleccionadoAlgoFormer()){
			if(!this.jugador.estaSeleccionadoAccion()){
				this.action();
			}
		} else {
			this.imprimirCaracteristicas(this.algoFormer);
		}

	}

	public void reDraw() {
		for(int i = 0; i < this.cantidadCasillerosX; i++){
			for(int j = 0; j < this.cantidadCasillerosY; j++){
				Casillero casillero = this.tablero.getCasillero(i,j);
				this.pintarTerreno(casillero.getTerrenoTerrestre(),pixCasilleroAncho * i, pixCasilleroAlto * j);
//				if(this.jugador.posiblesMovimientos.contains(casillero))
//					this.gc.setFill(Color.WHITE);
				if(casillero.tieneContenido()){
					this.pintarContenido(casillero.getContenido(),pixCasilleroAncho * i, pixCasilleroAlto * j);
				}

				/*

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
				*/
			}
		}
	
	}

	public void action() {
		Text textoNombreJugador = new Text();
		textoNombreJugador.setText("Juega "+ this.jugador.getNombre());
		textoNombreJugador.setFont(Font.font("Verdana",FontWeight.BOLD,12.5));
		textoNombreJugador.setFill(Color.ALICEBLUE);
		root.getChildren().add(textoNombreJugador);
		textoNombreJugador.relocate(sceneX/2 - 120,sceneY - 30);		
		
		Text textoSeleccionAccion = new Text();
		textoSeleccionAccion.setFont(Font.font("Verdana",FontWeight.BOLD,12));
		textoSeleccionAccion.setText("Seleccione accion");
		textoSeleccionAccion.setFill(Color.ANTIQUEWHITE);
		root.getChildren().add(textoSeleccionAccion);
		textoSeleccionAccion.relocate(sceneX/2,sceneY - 30);
		
		
		ArrayList<String> acciones = new ArrayList<String>();
		acciones.add("Atacar");
		acciones.add("Mover");
		acciones.add("Transformar");
		
		Jugador jugador = juego.getJugadorTurno();
		int indexSelecAction = jugador.getSelectAccion();
		String selectAction = acciones.get(indexSelecAction);
		acciones.set(indexSelecAction, "> ".concat(selectAction));
		
		Text textoAccionesPosibles = new Text();
		String separador = "  ";
		textoAccionesPosibles.setFont(Font.font("Verdana",FontWeight.BOLD,12));
		textoAccionesPosibles.setText(acciones.get(0) + separador + acciones.get(1) + separador + acciones.get(2));
		textoAccionesPosibles.setFill(Color.ANTIQUEWHITE);
		root.getChildren().add(textoAccionesPosibles);
		textoAccionesPosibles.relocate(sceneX/2 + 120,sceneY - 30);	

		
	}

	private void pintarContenido(Contenido contenido,int i,int j) {
		String contenidoName = contenido.getClass().getName();
			contenidoName = contenidoName.replace("fiuba.algo3.tablero.","");
			contenidoName = contenidoName.replace("fiuba.algo3.algoformers.personajes.","");

			Image image = new Image("/"+contenidoName+".png");
		gc.drawImage(image,i,j);
		
	}

	private void pintarTerreno(Terreno terreno, int i, int j) {
		String terrenoCasillero = terreno.getClass().getName();
		terrenoCasillero = terrenoCasillero.replace("fiuba.algo3.tablero.","");
		Image image;
		image = new Image("/"+terrenoCasillero+".png");
		gc.drawImage(image,i,j);
	}

	public void imprimirCaracteristicas(AlgoFormer unAlgoFormer){

		Text textoAlgoFormer = new Text();
		textoAlgoFormer.setFont(Font.font("Verdana",FontWeight.EXTRA_BOLD,12));
		textoAlgoFormer.setTextAlignment(TextAlignment.CENTER);
		textoAlgoFormer.setText(unAlgoFormer.getNombre()+ '('+unAlgoFormer.getVida()+')');
		textoAlgoFormer.setFill(Color.SALMON);
		root.getChildren().add(textoAlgoFormer);
		textoAlgoFormer.relocate(sceneX*0.8,sceneY * 0.1);
		
		
		String nombreEstado;
		if(unAlgoFormer.esHumanoide()){
			nombreEstado = "Humanoide";
		} else {
			nombreEstado = "Alterno";
		}
		String nombreTipoUnidad;
		if(unAlgoFormer.esTerrestre()){
			nombreTipoUnidad = "Terrestre";
		} else {
			nombreTipoUnidad = "Aereo";
		}
		Text textoCaracteristicas = new Text();
		textoCaracteristicas.setFont(Font.font("Verdana",FontWeight.BOLD,12));
		textoCaracteristicas.setText(
				
				"velocidad: " + unAlgoFormer.getVelocidad()+'\n'+
				"Distancia de ataque: " + unAlgoFormer.getDistanciaAtaque()+'\n'+
				"Fuerza de ataque: " + unAlgoFormer.getFuerzaAtaque()+'\n'+
				nombreEstado+ ' ' + nombreTipoUnidad 
				
		);
		textoCaracteristicas.setFill(Color.WHEAT);
		root.getChildren().add(textoCaracteristicas);
		textoCaracteristicas.relocate(sceneX*0.8,15 + (sceneY * 0.1));
		
		
	}
}
