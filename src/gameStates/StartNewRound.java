package gameStates;

import enums.EText;
import gameStatesDefault.GameState;
import managers.TribePlayerManager;
import model.Tribe;
import utils.Flow;

public class StartNewRound extends GameState {

	@Override
	public void execute() {

		EText.START_NEW_ROUND.show();
		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Tribe tribe = TribePlayerManager.INSTANCE.getActiveTribe();

		if (tribe == null)
			Flow.INSTANCE.executeGameState(ChooseTribe.class);

	}

}
