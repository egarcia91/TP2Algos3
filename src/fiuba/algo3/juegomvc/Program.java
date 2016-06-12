package fiuba.algo3.juegomvc;

import fiuba.algo3.juegomvc.modelo.*;
import fiuba.algo3.tablero.*;
import fiuba.algo3.algoformers.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	GraphicsContext gc;
	BoxView boxView;

	@Override
	public void start(Stage primaryStage) throws Exception {

//		Robot robot = createModel();

		Tablero tablero = new Tablero(7, 7);
		EscuadronAutobot escuadronAutoBot = new EscuadronAutobot();
		EscuadronDecepticon escuadronDecepticon = new EscuadronDecepticon();
		tablero.setItem(new Spark(),3,3);
		tablero.agregarEscuadron(escuadronAutoBot);
		tablero.agregarEscuadron(escuadronDecepticon);

		primaryStage.setTitle("Autobots fight untill end. Decepticions allways loose");

		Group canvasContainer = new Group();
		Canvas canvas = new Canvas(600, 600);
		gc = canvas.getGraphicsContext2D();
//		this.boxView = new BoxView(gc, robot);
		this.boxView = new BoxView(gc, tablero);
		this.boxView.draw();

		canvasContainer.getChildren().add(canvas);

		Button moveRButton = new Button();
		moveRButton.setText("MoveDerecha");
//		MoveButtonHandler moveButtonHandler = new MoveButtonHandler(this.boxView, robot);
//		moveButton.setOnAction(moveButtonHandler);

		Button moveLButton = new Button();
		moveLButton.setText("MoverIzquiera");
//		DirectionButtonHandler directionButtonHandler = new DirectionButtonHandler(robot);
//		directionButton.setOnAction(directionButtonHandler);

		Button moveDButton = new Button();
		moveDButton.setText("MoverAbajo");
//		MoveButtonHandler moveButtonHandler = new MoveButtonHandler(this.boxView, robot);
//		moveButton.setOnAction(moveButtonHandler);

		Button moveUButton = new Button();
		moveUButton.setText("MoverArriba");
//		DirectionButtonHandler directionButtonHandler = new DirectionButtonHandler(robot);
//		directionButton.setOnAction(directionButtonHandler);

		HBox contenedorHorizontal = new HBox(moveRButton, moveLButton, moveUButton, moveDButton);
		contenedorHorizontal.setSpacing(10);

		VBox contenedorPrincipal = new VBox(contenedorHorizontal, canvasContainer);
		contenedorPrincipal.setSpacing(10);
		contenedorPrincipal.setPadding(new Insets(20));

		primaryStage.setScene(new Scene(contenedorPrincipal,1000,1000));
		primaryStage.show();

		//BotonLimpiarEventHandler botonLimpiarEventHandler = new BotonLimpiarEventHandler(texto);
		//botonLimpiar.setOnAction(botonLimpiarEventHandler);

		//BotonEnviarEventHandler botonEnviarEventHandler = new BotonEnviarEventHandler(texto, etiqueta);
		//botonEnviar.setOnAction(botonEnviarEventHandler);

		//TextoEventHandler textoEventHandler = new TextoEventHandler(botonEnviar);
		//texto.setOnKeyPressed(textoEventHandler);



		//Scene scene = new Scene(contenedorPrincipal, 300, 250);

		//stage.setScene(scene);

		//stage.show();
	}

//	private Robot createModel() {
//		Box box = new Box(1500,1500);
//		Sensor sensor = new Sensor(box);
//		Robot robot = new Robot(sensor, new Position(25,25));
//		robot.setDirection(Direction.east());
//		return robot;
//	}

//	private Juego createModel() {
//		Box box = new Box(50,50);
//		Sensor sensor = new Sensor(box);
//		Robot robot = new Robot(sensor, new Position(0,0));
//		robot.setDirection(Direction.east());
//		return robot;
//	}
}
