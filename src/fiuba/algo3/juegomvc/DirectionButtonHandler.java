package fiuba.algo3.juegomvc;

import fiuba.algo3.juegomvc.modelo.Robot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DirectionButtonHandler implements EventHandler<ActionEvent> {

	private final Robot robot;

	public DirectionButtonHandler(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		this.robot.rotate();
	}
}



