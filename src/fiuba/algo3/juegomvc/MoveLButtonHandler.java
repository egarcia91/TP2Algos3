package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.*;
import fiuba.algo3.tablero.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveLButtonHandler implements EventHandler<ActionEvent> {

	private final BoxView view;
	private final Juego juego;

	public MoveLButtonHandler(BoxView view, Juego juego) {
		this.view = view;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		if(!jugadorTurnoActual.estaSeleccionadoAlgoFormer()){
			jugadorTurnoActual.prevAlgoFormer();
		} else if(!jugadorTurnoActual.estaSeleccionadoAccion()) {
			jugadorTurnoActual.prevAccion();
		} else {
			switch (jugadorTurnoActual.getSelectAccion()){
				case 0:
//					jugadorTurnoActual.selectAlgoFormerRival();
					break;
				case 1:
					jugadorTurnoActual.leftPosicion();
					break;
				default:
					break;
			}
		}

		this.view.update();
	}

}

