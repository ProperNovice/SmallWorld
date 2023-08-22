package gameStates;

import enums.EText;
import gameStatesDefault.GameState;
import model.Board;

public class ChooseTribe extends GameState {

	@Override
	public void execute() {

		showTribesPanel();

	}

	@Override
	protected void executeTextOption(EText eText) {

		concealText();

		switch (eText) {

		case SHOW_BOARD:
			showMapPanel();
			break;

		case SHOW_TRIBES:
			showTribesPanel();
			break;

		default:
			break;

		}

	}

	private void showTribesPanel() {

		Board.INSTANCE.fill();
		Board.INSTANCE.show();

		EText.CHOOSE_TRIBE.show();
		EText.SHOW_BOARD.show();

	}

	private void showMapPanel() {

		Board.INSTANCE.hide();

		EText.CHOOSE_TRIBE.show();
		EText.SHOW_TRIBES.show();

	}

}
