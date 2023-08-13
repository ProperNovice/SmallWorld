package managers;

import enums.ESpecialPower;
import model.SpecialPower;
import utils.ArrayList;
import utils.HashMap;

public enum SpecialPowersManager {

	INSTANCE;

	private HashMap<ESpecialPower, SpecialPower> list = new HashMap<>();
	private ArrayList<ESpecialPower> specialPowers = new ArrayList<>(ESpecialPower.values());

	private SpecialPowersManager() {

	}

	public SpecialPower getRandomSpecialPower() {

		ESpecialPower eSpecialPower = this.specialPowers.removeRandom();

		if (!this.list.containsKey(eSpecialPower))
			this.list.put(eSpecialPower, new SpecialPower(eSpecialPower));

		return this.list.getValue(eSpecialPower);

	}

}
