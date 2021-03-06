package fiuba.algo3.juegomvc;

import fiuba.algo3.tablero.*;
import fiuba.algo3.algoformers.*;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.image.ImageView;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;

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
	TextFlow textFlowAcciones;
	TextFlow textFlowAlgoformer;
	
	

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
		this.nombreJugador();
		if(!this.jugador.estaSeleccionadoAlgoFormer()){
			this.seleccionePersonaje();
		} else {
			if(!this.jugador.estaSeleccionadoAccion()){
				this.action();
			}
		}
		this.imprimirCaracteristicas(this.algoFormer);
	}

	public void reDraw() {
		for(int i = 0; i < this.cantidadCasillerosX; i++){
			for(int j = 0; j < this.cantidadCasillerosY; j++){
				Posicion posicion = new Posicion(i,j);
				Casillero casillero = this.tablero.getCasillero(i,j);
				this.pintarTerreno(casillero.getTerrenoTerrestre(),pixCasilleroAncho * i, pixCasilleroAlto * j);

				if(this.jugador.casillerosEnRango.contains(casillero)){
					switch(this.jugador.getAccionSeleccionada()){
						case 1:
							this.pintarContenidoSeleccionado(pixCasilleroAncho * i, pixCasilleroAlto * j);
							break;
						case 0:
							this.pintarAtaque(pixCasilleroAncho * i, pixCasilleroAlto * j);
							//this.pintarTerreno(casillero.getTerrenoTerrestre(),pixCasilleroAncho * i, pixCasilleroAlto * j);
							break;
						default:
							break;
					}
				}

				if(posicion.equals(this.jugador.posicionPosibleMovimiento)){
					this.pintarPosicionFutura(pixCasilleroAncho * i, pixCasilleroAlto * j);
				}

				if(casillero.tieneContenido()){
					Contenido contenido = casillero.getContenido();
					this.pintarContenido(contenido,pixCasilleroAncho * i, pixCasilleroAlto * j);
					if(!this.jugador.estaSeleccionadoAlgoFormer() && this.algoFormer == contenido){
						this.pintarContenidoSeleccionado(pixCasilleroAncho * i, pixCasilleroAlto * j);
					}
				}
			}
		}
	
	}

	public void nombreJugador() {
		this.gc.setFont(Font.font("Verdana",FontWeight.BOLD,25));
		this.gc.setFill(Color.ALICEBLUE);
		this.gc.fillText("Turno Jugador "+ this.jugador.getNombre(),sceneX*0.5,sceneY * 0.1);
	}

	public void seleccionePersonaje() {
		this.gc.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		this.gc.setFill(Color.ANTIQUEWHITE);
		this.gc.fillText("Seleccione Personaje",sceneX*0.4,sceneY * 0.25);
	}

	public void action() {

		this.gc.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		this.gc.setFill(Color.ANTIQUEWHITE);
		this.gc.fillText("Seleccione accion",sceneX*0.5,sceneY * 0.25);

		ArrayList<String> acciones = new ArrayList<String>();
		acciones.add("Atacar");
		acciones.add("Mover");
		acciones.add("Transformar");
		
		Jugador jugador = juego.getJugadorTurno();
		int indexSelecAction = jugador.getSelectAccion();
		String selectAction = acciones.get(indexSelecAction);
		acciones.set(indexSelecAction, "> ".concat(selectAction));
		
		String separador = "  ";
		this.gc.setFont(Font.font("Verdana",FontWeight.BOLD,17));
		this.gc.setFill(Color.ANTIQUEWHITE);
		this.gc.fillText(acciones.get(0) + separador + acciones.get(1) + separador + acciones.get(2),sceneX*0.5,sceneY * 0.3);

	}

	private void pintarPosicionFutura(int i,int j) {
		Image image = new Image("/posicionFutura.png");
		gc.drawImage(image,i,j);
	}
	
	private void pintarAtaque(int i,int j){
		Image image = new Image("/Ataque.png");
		gc.drawImage(image,i,j);
	}


	private void pintarContenidoSeleccionado(int i,int j) {
		Image image = new Image("/PosibleMovimiento.png");
		gc.drawImage(image,i,j);
	}

	private void pintarContenido(Contenido contenido,int i,int j) {
		String contenidoName = contenido.getClass().getName();
		contenidoName = contenidoName.replace("fiuba.algo3.tablero.","");
		contenidoName = contenidoName.replace("fiuba.algo3.algoformers.personajes.","");
		Image image;
		if(contenido.esAlgoFormer() == true){
			AlgoFormer algoFormer = (AlgoFormer) contenido;
			image = new Image("/"+contenidoName+ algoFormer.getNombreEstado() +".png");
		}
		else{
			image = new Image("/"+contenidoName+".png");
		}	
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

		gc.setFont(Font.font("Verdana",FontWeight.EXTRA_BOLD,19));
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFill(Color.SALMON);
		gc.fillText(unAlgoFormer.getNombre()+ '('+unAlgoFormer.getVida()+')',sceneX*0.8,sceneY * 0.1);

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

		gc.setFont(Font.font("Verdana",FontWeight.BOLD,17));
		gc.setFill(Color.WHEAT);
		gc.fillText(
		"velocidad: " + unAlgoFormer.getVelocidad()+'\n'+
		"Distancia de ataque: " + unAlgoFormer.getDistanciaAtaque()+'\n'+
		"Fuerza de ataque: " + unAlgoFormer.getFuerzaAtaque()+'\n'+
		nombreEstado+ ' ' + nombreTipoUnidad,
		sceneX*0.8,
		25 + (sceneY * 0.1));
		for(Iterator<Item> i = unAlgoFormer.getItems().iterator(); i.hasNext();){
			gc.fillText("Bonus! :" +  i.next().getNombre(), sceneX*0.8, (sceneY * 0.1) - 100 );
		}
	}
}
