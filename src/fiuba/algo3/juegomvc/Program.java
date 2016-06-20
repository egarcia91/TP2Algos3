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
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
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

		Juego juego = new Juego();
		Jugador jugadorUno = new Jugador("Sam");
		Jugador jugadorDos = new Jugador("Max");
		juego.agregarJugador(jugadorUno);
		juego.agregarJugador(jugadorDos);

		primaryStage.setTitle("Autobots fight untill end. Decepticions allways loose");

		Group canvasContainer = new Group();
		Canvas canvas = new Canvas(600, 600);
		gc = canvas.getGraphicsContext2D();
		this.boxView = new BoxView(gc, juego);
		this.boxView.draw();

		canvasContainer.getChildren().add(canvas);

		Button moveRButton = new Button();
		moveRButton.setText("Derecha");
		MoveRButtonHandler moveRButtonHandler = new MoveRButtonHandler(this.boxView, juego);
		moveRButton.setOnAction(moveRButtonHandler);

		Button moveLButton = new Button();
		moveLButton.setText("Izquierda");
		MoveLButtonHandler moveLButtonHandler = new MoveLButtonHandler(this.boxView, juego);
		moveLButton.setOnAction(moveLButtonHandler);

		Button moveDButton = new Button();
		moveDButton.setText("Abajo");
		MoveDButtonHandler moveDButtonHandler = new MoveDButtonHandler(this.boxView, juego);
		moveDButton.setOnAction(moveDButtonHandler);

		Button moveUButton = new Button();
		moveUButton.setText("Arriba");
		MoveUButtonHandler moveUButtonHandler = new MoveUButtonHandler(this.boxView, juego);
		moveUButton.setOnAction(moveUButtonHandler);

		Button aButton = new Button();
		aButton.setText("A");
		AButtonHandler aButtonHandler = new AButtonHandler(this.boxView, juego);
		aButton.setOnAction(aButtonHandler);

		Button bButton = new Button();
		bButton.setText("B");
//		DirectionButtonHandler directionButtonHandler = new DirectionButtonHandler(robot);
//		directionButton.setOnAction(directionButtonHandler);

		HBox contenedorHorizontal = new HBox(moveRButton, moveLButton, moveUButton, moveDButton, aButton, bButton);
		contenedorHorizontal.setSpacing(10);

		VBox contenedorPrincipal = new VBox(canvasContainer, contenedorHorizontal);
		contenedorPrincipal.setSpacing(10);
		contenedorPrincipal.setPadding(new Insets(20));

		primaryStage.setScene(new Scene(contenedorPrincipal,1000,1000));
		primaryStage.show();

	}
}
