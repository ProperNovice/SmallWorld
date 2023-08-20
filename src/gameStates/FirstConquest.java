package gameStates;

import enums.EFilter;
import enums.ERegionType;
import gameStatesDefault.GameState;
import managers.RegionModel;
import model.Region;
import utils.ArrayList;

public class FirstConquest extends GameState {

	@Override
	public void execute() {

		ArrayList<Region> list = RegionModel.INSTANCE.getAllRegionsFilterWater(EFilter.OUT);

		RegionModel.INSTANCE.filterRegionsAdjacentToERegionType(list, ERegionType.SEA, EFilter.OUT);

		for (Region region : list)
			region.setSelected();

	}

}
