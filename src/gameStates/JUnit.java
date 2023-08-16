package gameStates;

import enums.ERace;
import enums.ERegionType;
import enums.EToken;
import gameStatesDefault.GameState;
import managers.MapManager;
import managers.TribePlayerManager;
import managers.RacesManager;
import managers.SpecialPowersManager;
import model.Race;
import model.Tribe;
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
		Tribe raceSpecialPower = new Tribe(race, specialPower);
		TribePlayerManager.INSTANCE.addTribe(raceSpecialPower);

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
