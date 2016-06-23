package fiuba.algo3.juegomvc;

import fiuba.algo3.juegomvc.modelo.*;
import fiuba.algo3.tablero.*;

import java.util.ArrayList;

import fiuba.algo3.algoformers.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Program extends Application {
	double pixCasilleroAncho = 48;
	double pixCasilleroAlto = 48;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	GraphicsContext gc;
	BoxView boxView;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		double resolucionPantallaX = visualBounds.getWidth();
		double resolucionPantallaY = visualBounds.getHeight();
		
		Group root = new Group();
  		
		primaryStage.setTitle("Autobots fight untill end. Decepticions allways loose");
		primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
		
        Scene scene = new Scene(root,resolucionPantallaX,resolucionPantallaY);
		scene.setFill(Color.BLACK);
		primaryStage.setScene(scene);
        
		double canvasAncho = resolucionPantallaX * 0.9;
        double canvasAlto = resolucionPantallaY * 0.9;
		Canvas canvas = new Canvas(canvasAncho,canvasAlto);
		root.getChildren().add(canvas);
			
		gc = canvas.getGraphicsContext2D();
        
		Juego juego = new Juego((int)Math.ceil(canvasAncho/pixCasilleroAncho)-1,(int)Math.ceil(canvasAlto/pixCasilleroAlto)-1);
		Jugador jugadorUno = new Jugador("Sam");
		Jugador jugadorDos = new Jugador("Max");
		juego.agregarJugador(jugadorUno);
		juego.agregarJugador(jugadorDos);


		this.boxView = new BoxView(gc, juego);
		this.boxView.draw();

		HBox botonera = crearBotonera(juego);
		root.getChildren().add(botonera);
		botonera.relocate(20,canvasAlto + 20);
		
		
		
		//VBox contenedorPrincipal = new VBox(root, contenedorBotones);
		//contenedorPrincipal.setSpacing(10);
		//contenedorPrincipal.setPadding(new Insets(20));
		primaryStage.show();

	}

	private HBox crearBotonera(Juego juego){
		MoveLButtonHandler moveLButtonHandler = new MoveLButtonHandler(this.boxView, juego);
		Button botonIzquierda = crearBoton("Izquierda",moveLButtonHandler);
		
		MoveRButtonHandler moveRButtonHandler = new MoveRButtonHandler(this.boxView, juego);
		Button botonDerecha = crearBoton("Derecha",moveRButtonHandler);
		
		MoveDButtonHandler moveDButtonHandler = new MoveDButtonHandler(this.boxView, juego);
		Button botonAbajo = crearBoton("Abajo",moveDButtonHandler);
		
		MoveUButtonHandler moveUButtonHandler = new MoveUButtonHandler(this.boxView, juego);
		Button botonArriba = crearBoton("Arriba",moveUButtonHandler);
		
		AButtonHandler aButtonHandler = new AButtonHandler(this.boxView, juego);
		Button botonA = crearBoton("A",aButtonHandler);
		
		HBox contenedorBotones = new HBox(botonIzquierda,botonArriba,botonAbajo,botonDerecha,botonA);
		contenedorBotones.setSpacing(10);
		return contenedorBotones;
	}

	private Button crearBoton(String texto,EventHandler<ActionEvent> handler){
		Button button = new Button();
		button.setText(texto);
		button.setOnAction(handler);
		return button;
	}	
	/*
	public void action() {
		Text textoInformacion = new Text();
		textoInformacion.setTextAlignment(TextAlignment.CENTER);
		textoInformacion.setText("AlgoFormer: "+ this.algoFormer.getNombre());
		this.gc.setFill(Color.BLACK);
		//this.gc.fillText(,50,450);
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
	*/

	
}
