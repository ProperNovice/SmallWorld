package managers;

import enums.ERace;
import model.Race;
import utils.ArrayList;
import utils.HashMap;

public enum RacesManager {

	INSTANCE;

	private HashMap<ERace, Race> list = new HashMap<>();
	private ArrayList<ERace> races = new ArrayList<>(ERace.values());

	private RacesManager() {

	}

	public Race getRandomRace() {

		ERace eRace = this.races.removeRandom();

		if (!this.list.containsKey(eRace))
			this.list.put(eRace, new Race(eRace));

		return this.list.getValue(eRace);

	}

}
