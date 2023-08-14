package gameStates;

import enums.EToken;
import enums.ERegionType;
import gameStatesDefault.GameState;
import maps.Map;
import maps.MapVanilla2;
import model.Region;
import tokens.TokenNonRace;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Map map = new MapVanilla2();

		for (Region region : map.getRegions()) {

			if (region.getERegionType().equals(ERegionType.MOUNTAIN))
				region.addTokenStaticRelocate(new TokenNonRace(EToken.MOUNTAIN));

			if (region.hasLostTribeSymbol())
				region.addTokenLinearRelocate(new TokenNonRace(EToken.LOSTTRIBES));

		}

	}

}
