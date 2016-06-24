package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.tablero.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	public void start(Stage mainStage) throws Exception {

		Group root = new Group();/*
		GridPane grid = definirNombresJugadores();
		Scene primaryScene = new Scene(root);
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
		definirNombresJugadores();
		*/
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		double resolucionPantallaX = visualBounds.getWidth();
		double resolucionPantallaY = visualBounds.getHeight();
		
		mainStage.centerOnScreen();
        mainStage.setResizable(false);
        mainStage.setFullScreen(true);
		
        Scene scene = new Scene(root,resolucionPantallaX,resolucionPantallaY);
		scene.setFill(Color.BLACK);
		mainStage.setScene(scene);
        
		double canvasAncho = resolucionPantallaX;
        double canvasAlto = resolucionPantallaY;
		Canvas canvas = new Canvas(canvasAncho,canvasAlto);
		root.getChildren().add(canvas);
		canvas.relocate(10,10);
		
		gc = canvas.getGraphicsContext2D();

		try{

				Path currentRelativePath = Paths.get("");
				String s = currentRelativePath.toAbsolutePath().toString();
				File file = new File(s + "/src/Transformers8bit.mp3");
				String path = file.toURI().toASCIIString();
				AudioClip audioClip = new AudioClip(path);
				audioClip.play();

		}catch(IllegalArgumentException e){};	
		

		Juego juego = new Juego((int)Math.ceil(canvasAncho/pixCasilleroAncho)-1,(int)Math.ceil(canvasAlto/pixCasilleroAlto)-2);
		Jugador jugadorUno = new Jugador("Sam");
		Jugador jugadorDos = new Jugador("Max");
		juego.agregarJugador(jugadorUno);
		juego.agregarJugador(jugadorDos);


		this.boxView = new BoxView(root,resolucionPantallaX,resolucionPantallaY,gc, juego);
		this.boxView.draw();

		HBox botonera = crearBotonera(juego);
		root.getChildren().add(botonera);
		botonera.relocate(20,resolucionPantallaY * 0.95 + 10);
		

			//VBox contenedorPrincipal = new VBox(root, contenedorBotones);
		//contenedorPrincipal.setSpacing(10);
		//contenedorPrincipal.setPadding(new Insets(20));
		mainStage.show();
		

		
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
		
		BButtonHandler bButtonHandler = new BButtonHandler(this.boxView, juego);
		Button botonB = crearBoton("B",bButtonHandler);
		
		HBox contenedorBotones = new HBox(botonIzquierda,botonArriba,botonAbajo,botonDerecha,botonA,botonB);
		contenedorBotones.setSpacing(10);
		return contenedorBotones;
	}

	private Button crearBoton(String texto,EventHandler<ActionEvent> handler){
		Button button = new Button();
		button.setText(texto);
		button.setOnAction(handler);
		return button;
	}	
	
	private GridPane definirNombresJugadores(){
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);

		final TextField name = new TextField();
		name.setPromptText("Ingrese nombre del jugador Autobot!");
		name.setPrefColumnCount(10);
		name.getText();
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);

		final TextField lastName = new TextField();
		lastName.setPromptText("Ingrese nombre del jugador Decepticon >_<");
		GridPane.setConstraints(lastName, 0, 1);
		grid.getChildren().add(lastName);

		Button botonOk = new Button("Ok");
		GridPane.setConstraints(botonOk, 1, 0);
		grid.getChildren().add(botonOk);
		return grid;
	}
}	
