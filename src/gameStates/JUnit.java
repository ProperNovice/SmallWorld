package gameStates;

import enums.EPlayer;
import enums.ERegionType;
import enums.EToken;
import gameStatesDefault.GameState;
import managers.MapManager;
import managers.RacesManager;
import managers.SpecialPowersManager;
import managers.TokenManager;
import managers.TokenPool;
import managers.TribePlayerManager;
import model.Race;
import model.Region;
import model.SpecialPower;
import model.Tribe;
import tokens.Token;
import tokens.TokenNonRace;
import utils.ArrayList;
import utils.Flow;

public class JUnit extends GameState {

	@Override
	public void execute() {

		addMountains();
		createStartingLostTribes();
		addStartingLostTribes();

		addRandomTribeActive();

		Flow.INSTANCE.executeGameState(FirstConquest.class);

	}

	public void addRandomTribeActive() {

		Race race = RacesManager.INSTANCE.getRandomRace();
		SpecialPower specialPower = SpecialPowersManager.INSTANCE.getRandomSpecialPower();
		Tribe raceSpecialPower = new Tribe(race, specialPower);
		TribePlayerManager.INSTANCE.addTribe(raceSpecialPower);

		int tokensNeeded = 0;
		tokensNeeded += race.getERace().getValue();
		tokensNeeded += specialPower.getESpecialPower().getValue();

		ArrayList<Token> tokens = TokenPool.INSTANCE.getTokensRace(race.getERace(), tokensNeeded);

		TokenManager.INSTANCE.addTokens(EPlayer.HUMAN, tokens);

	}

	public void addMountains() {

		for (Region region : MapManager.INSTANCE.getRegionsClone()) {

			if (region.getERegionType().equals(ERegionType.MOUNTAIN))
				region.addTokenStaticRelocate(new TokenNonRace(EToken.MOUNTAIN));

		}

	}

	public void createStartingLostTribes() {

		ArrayList<Token> tokens = TokenPool.INSTANCE.getTokensNonRace(EToken.LOSTTRIBES, 16);
		TokenManager.INSTANCE.addTokens(EPlayer.BOT, tokens);

	}

	public void addStartingLostTribes() {

		for (Region region : MapManager.INSTANCE.getRegionsClone()) {

			if (!region.hasLostTribeSymbol())
				continue;

			ArrayList<Token> list = TokenManager.INSTANCE.getTokens(EPlayer.BOT, 1, true);

			region.addTokensLinearRelocate(list);

		}

	}

}
