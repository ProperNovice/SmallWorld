package gameStates;

import enums.EFilter;
import enums.EPlayer;
import enums.ERace;
import enums.ERegionType;
import enums.EToken;
import gameStatesDefault.GameState;
import managers.CoinManager;
import managers.MapManager;
import managers.ModelRegion;
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
import tokens.TokenRace;
import utils.ArrayList;
import utils.Flow;

public class JUnit extends GameState {

	@Override
	public void execute() {

		addMountains();
		createStartingLostTribes();
		addStartingLostTribes();
		addCoins(EPlayer.HUMAN, 5);

//		addRandomTribeActive();

//		addTokenRaceToRegion(ERace.HALFLINGS, 2, 20);

		Flow.INSTANCE.executeGameState(StartNewRound.class);

	}

	public void addTokenRaceToRegion(ERace eRace, int tokens, int region) {

		ArrayList<Token> list = new ArrayList<>();

		for (int counter = 1; counter <= tokens; counter++)
			list.addLast(new TokenRace(eRace));

		ModelRegion.INSTANCE.getAllRegionsFilterWater(EFilter.IN).get(region)
				.addTokensLinearRelocate(list);

	}

	public void addRandomTribeActive() {

		Race race = RacesManager.INSTANCE.getRandomRace();
		SpecialPower specialPower = SpecialPowersManager.INSTANCE.getRandomSpecialPower();
		Tribe raceSpecialPower = new Tribe(race, specialPower);
		TribePlayerManager.INSTANCE.addActiveTribe(raceSpecialPower);

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

	public void addCoins(EPlayer ePlayer, int amount) {
		CoinManager.INSTANCE.addCoins(ePlayer, amount);
	}

}
