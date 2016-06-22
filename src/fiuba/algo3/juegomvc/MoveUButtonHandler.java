package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.*;
import fiuba.algo3.tablero.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveUButtonHandler implements EventHandler<ActionEvent> {

	private final BoxView view;
	private final Juego juego;

	public MoveUButtonHandler(BoxView view, Juego juego) {
		this.view = view;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		if(!jugadorTurnoActual.estaSeleccionadoAlgoFormer()){
			jugadorTurnoActual.nextAlgoFormer();
		} else if(!jugadorTurnoActual.estaSeleccionadoAccion()){
			jugadorTurnoActual.nextAccion();
		} else if(!jugadorTurnoActual.estaSeleccionadoAlgoFormerRival()) {
			jugadorTurnoActual.nextAlgoFormerRival();
		}
		this.view.update();
	}
}

