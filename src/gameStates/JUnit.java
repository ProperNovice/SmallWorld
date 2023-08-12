package gameStates;

import gameStatesDefault.GameState;
import maps.Map;
import maps.MapVanilla2;
import regions.Region;
import tokens.LostTribes;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Map map = new MapVanilla2();

		for (Region region : map.getRegions()) {

			if (region.hasLostTribeSymbol())
				region.addTokenLinearRelocate(new LostTribes());

		}

	}

}
