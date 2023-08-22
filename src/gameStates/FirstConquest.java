package gameStates;

import enums.EFilter;
import gameStatesDefault.GameState;
import managers.ModelRegion;
import model.Region;
import utils.ArrayList;

public class FirstConquest extends GameState {

	@Override
	public void execute() {

		ArrayList<Region> list = ModelRegion.INSTANCE.getAllRegionsFilterWater(EFilter.OUT);

		ModelRegion.INSTANCE.filterBorderRegions(list, EFilter.IN);
		ModelRegion.INSTANCE.filterRegionsContainTokenRace(list, EFilter.OUT);

		for (Region region : list)
			region.setSelected();

	}

}
