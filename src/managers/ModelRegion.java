package managers;

import enums.EFilter;
import enums.ERegionType;
import model.Region;
import utils.ArrayList;

public enum ModelRegion {

	INSTANCE;

	private ModelRegion() {

	}

	private boolean regionIsAdjacentToRegionType(Region region, ERegionType eRegionType) {

		ArrayList<Region> adjacents = MapManager.INSTANCE.getAdjacenciesClone(region);

		for (Region regionAdjacent : adjacents)
			if (regionAdjacent.getERegionType().equals(eRegionType))
				return true;

		return false;

	}

	public ArrayList<Region> filterBorderRegions(ArrayList<Region> list, EFilter eFilter) {

		for (Region region : list.clone()) {

			if (region.isBorder()) {

				if (eFilter.equals(EFilter.OUT))
					list.remove(region);

			} else if (eFilter.equals(EFilter.IN))
				list.remove(region);

		}

		return list;

	}

	public ArrayList<Region> filterRegionsContainTokenRace(ArrayList<Region> list,
			EFilter eFilter) {

		for (Region region : list.clone()) {

			if (region.containsTokenRace()) {

				if (eFilter.equals(EFilter.OUT))
					list.remove(region);

			} else if (eFilter.equals(EFilter.IN))
				list.remove(region);

		}

		return list;

	}

	public ArrayList<Region> filterRegionsAdjacentToERegionType(ArrayList<Region> list,
			ERegionType eRegionType, EFilter eFilter) {

		for (Region region : list.clone()) {

			if (regionIsAdjacentToRegionType(region, eRegionType)) {

				if (eFilter.equals(EFilter.OUT))
					list.remove(region);

			} else if (eFilter.equals(EFilter.IN))
				list.remove(region);

		}

		return list;

	}

	public ArrayList<Region> getAllRegionsFilterWater(EFilter eFilter) {

		ArrayList<Region> list = MapManager.INSTANCE.getRegionsClone();

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
