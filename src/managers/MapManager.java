package managers;

import maps.Map;
import maps.MapVanilla2;
import model.Region;
import utils.ArrayList;

public enum MapManager {

	INSTANCE;

	private Map map = new MapVanilla2();

	private MapManager() {

	}

	public ArrayList<Region> getRegionsClone() {
		return this.map.getRegions().clone();
	}

	public ArrayList<Region> getAdjacenciesClone(Region region) {
		return this.map.getAdjecencies(region).clone();
	}

}
