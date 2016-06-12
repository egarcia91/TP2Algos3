package fiuba.algo3.juegomvc;

import fiuba.algo3.juegomvc.modelo.Robot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveButtonHandler implements EventHandler<ActionEvent> {

	private final BoxView view;
	private final Robot robot;

	public MoveButtonHandler(BoxView view, Robot robot) {
		this.view = view;
		this.robot = robot;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		this.robot.move();
		this.view.update();
	}
}

