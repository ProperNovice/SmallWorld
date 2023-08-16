package managers;

import model.RaceSpecialPower;
import utils.Vector2;

public enum RaceSpecialPowerManager {

	INSTANCE;

	private RaceSpecialPower active = null, inDecline = null;

	private RaceSpecialPowerManager() {

	}

	public void addActiveRaceAndSpecialPower(RaceSpecialPower raceSpecialPower) {

		this.active = raceSpecialPower;
		relocate();

	}

	public void declineActiveRace() {

		this.inDecline = this.active;
		this.active = null;
		relocate();

	}

	private void relocate() {

		Vector2 vector2 = Credentials.INSTANCE.cRaceAndSpecialPower.clone();

		if (this.active != null) {

			this.active.relocateTopLeft(vector2);
			vector2.substractY(
					Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		}

		if (this.inDecline != null) {

			this.inDecline.relocateTopLeft(vector2);
			vector2.substractY(
					Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		}

	}

}
