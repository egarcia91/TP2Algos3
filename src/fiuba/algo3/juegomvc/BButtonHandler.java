package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.*;
import fiuba.algo3.tablero.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BButtonHandler implements EventHandler<ActionEvent> {

	private final BoxView view;
	private final Juego juego;

	public BButtonHandler(BoxView view, Juego juego) {
		this.view = view;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		if(jugadorTurnoActual.estaSeleccionadoAlgoFormer()){
			jugadorTurnoActual.deselectAlgoFormer();
		} else if(jugadorTurnoActual.estaSeleccionadoAccion()) {
			jugadorTurnoActual.deselectAccion();
		}

		this.view.update();
	}
}

