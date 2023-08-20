package managers;

import enums.EFilter;
import enums.ERegionType;
import model.Region;
import utils.ArrayList;

public enum RegionModel {

	INSTANCE;

	private RegionModel() {

	}

	public ArrayList<Region> filterRegionsAdjacentToSea(ArrayList<Region> list, EFilter eFilter) {

		for (Region region : list.clone()) {

		}

		return list;

	}

	public ArrayList<Region> getAllRegionsFilterWater(EFilter eFilter) {

		ArrayList<Region> list = MapManager.INSTANCE.getRegions().clone();

		for (Region region : list.clone()) {

			if (eFilter.equals(EFilter.IN))
				continue;

			ERegionType eRegionType = region.getERegionType();

			if (eRegionType.equals(ERegionType.SEA))
				list.remove(region);
			else if (eRegionType.equals(ERegionType.LAKE))
				list.remove(region);

		}

		return list;

	}

}
