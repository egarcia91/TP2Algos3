package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.tablero.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
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
  		
		primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
		
        Scene scene = new Scene(root,resolucionPantallaX,resolucionPantallaY);
		scene.setFill(Color.BLACK);
		primaryStage.setScene(scene);
        
		double canvasAncho = resolucionPantallaX;
        double canvasAlto = resolucionPantallaY;
		Canvas canvas = new Canvas(canvasAncho,canvasAlto);
		root.getChildren().add(canvas);
		canvas.relocate(10,10);
		
		gc = canvas.getGraphicsContext2D();
        
		
		//Media media = new Media(Test.class.getResource("/musica.mp3").toString());
		
    	//MediaPlayer player = new MediaPlayer(media); 
    	//player.play();
		
		Juego juego = new Juego((int)Math.ceil(canvasAncho/pixCasilleroAncho)-1,(int)Math.ceil(canvasAlto/pixCasilleroAlto)-1);
		Jugador jugadorUno = new Jugador("Sam");
		Jugador jugadorDos = new Jugador("Max");
		juego.agregarJugador(jugadorUno);
		juego.agregarJugador(jugadorDos);


		this.boxView = new BoxView(root,resolucionPantallaX,resolucionPantallaY,gc, juego);
		this.boxView.draw();

		HBox botonera = crearBotonera(juego);
		root.getChildren().add(botonera);
		botonera.relocate(20,canvasAlto + 10);
		

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
}	