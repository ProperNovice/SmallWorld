package gameStates;

import enums.ERace;
import enums.ERegionType;
import enums.EToken;
import gameStatesDefault.GameState;
import managers.MapManager;
import managers.RaceSpecialPowerManager;
import managers.RacesManager;
import managers.SpecialPowersManager;
import model.Race;
import model.RaceSpecialPower;
import model.Region;
import model.SpecialPower;
import tokens.TokenNonRace;
import tokens.TokenRace;

public class JUnit extends GameState {

	@Override
	public void execute() {

		addMountains();
		addStartingLostTribes();

		addRandomRaceSpecialPowerActive();

		new TokenRace(ERace.ORCS).getImageView().flip();

	}

	public void addRandomRaceSpecialPowerActive() {

		Race race = RacesManager.INSTANCE.getRandomRace();
		SpecialPower specialPower = SpecialPowersManager.INSTANCE.getRandomSpecialPower();
		RaceSpecialPower raceSpecialPower = new RaceSpecialPower(race, specialPower);
		RaceSpecialPowerManager.INSTANCE.addActiveRaceAndSpecialPower(raceSpecialPower);

	}

	public void addMountains() {

		for (Region region : MapManager.INSTANCE.getRegions()) {

			if (region.getERegionType().equals(ERegionType.MOUNTAIN))
				region.addTokenStaticRelocate(new TokenNonRace(EToken.MOUNTAIN));

		}

	}

	public void addStartingLostTribes() {

		for (Region region : MapManager.INSTANCE.getRegions()) {

			if (region.hasLostTribeSymbol())
				region.addTokenLinearRelocate(new TokenNonRace(EToken.LOSTTRIBES));

		}

	}

}
