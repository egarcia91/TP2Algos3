package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.*;
import fiuba.algo3.tablero.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveDButtonHandler implements EventHandler<ActionEvent> {

	private final BoxView view;
	private final Juego juego;

	public MoveDButtonHandler(BoxView view, Juego juego) {
		this.view = view;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		if(!jugadorTurnoActual.estaSeleccionadoAlgoFormer()){
			jugadorTurnoActual.prevAlgoFormer();
		} else {
			jugadorTurnoActual.prevAccion();
		}

		this.view.update();
	}

	public void moveDown(ActionEvent actionEvent){
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		if (jugadorTurnoActual.getSelectAccion()==1){
			//Casillero casilleroFuturo = new Casillero();
			//casilleroFuturo= jugadorTurnoActual.getSelectAlgoFormer().get
			jugadorTurnoActual.getSelectAlgoFormer().moverAbajo();
		}


		this.view.update();

	}



}

