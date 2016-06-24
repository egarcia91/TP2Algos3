package fiuba.algo3.juegomvc;

import fiuba.algo3.algoformers.*;
import fiuba.algo3.tablero.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AButtonHandler implements EventHandler<ActionEvent> {

	private final BoxView view;
	private final Juego juego;

	public AButtonHandler(BoxView view, Juego juego) {
		this.view = view;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		boolean notUpdate = false;
		Jugador jugadorTurnoActual = this.juego.getJugadorTurno();
		
		if(!jugadorTurnoActual.estaSeleccionadoAlgoFormer()){
			jugadorTurnoActual.selectAlgoFormer();
		} else if(!jugadorTurnoActual.estaSeleccionadoAccion()) {
			try{
				jugadorTurnoActual.selectAccion();
			}catch(CasilleroOcupadoException e){ 
				notUpdate = true;
			}	
		} else {
			switch (jugadorTurnoActual.getSelectAccion()){
				case 0:
					jugadorTurnoActual.selectAlgoFormerRival();
					break;
				case 1:
					jugadorTurnoActual.selectMovimiento();
					break;
				default:
					System.out.println("Ataque");
					jugadorTurnoActual.atacarAlgoFormer();
					break;
			}
		}
		if(notUpdate == false)
			this.view.update();
	}




}

