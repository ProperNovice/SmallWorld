package managers;

import enums.ERace;
import model.Race;
import utils.HashMap;

public enum RacesManager {

	INSTANCE;

	private HashMap<ERace, Race> list = new HashMap<>();

	private RacesManager() {

	}

}
