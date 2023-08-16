package managers;

import model.Tribe;
import utils.Vector2;

public enum TribePlayerManager {

	INSTANCE;

	private Tribe active = null, inDecline = null;

	private TribePlayerManager() {

	}

	public void addTribe(Tribe tribe) {

		this.active = tribe;
		relocate();

	}

	public void declineActiveRace() {

		this.inDecline = this.active;
		this.active = null;
		relocate();

	}

	private void relocate() {

		Vector2 vector2 = Credentials.INSTANCE.cTribesPlayer.clone();

		if (this.active != null) {

			this.active.relocateTopLeft(vector2);
			vector2.addY(
					Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		}

		if (this.inDecline != null) {

			this.inDecline.relocateTopLeft(vector2);
			vector2.addY(
					Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		}

	}

}
