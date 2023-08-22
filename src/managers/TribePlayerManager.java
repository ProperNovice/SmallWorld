package managers;

import model.Tribe;
import utils.Vector2;

public enum TribePlayerManager {

	INSTANCE;

	private Tribe activeTribe = null, inDeclineTribe = null;

	private TribePlayerManager() {

	}

	public void addActiveTribe(Tribe tribe) {

		this.activeTribe = tribe;
		relocate();

	}

	public void declineActiveRace() {

		this.inDeclineTribe = this.activeTribe;
		this.activeTribe = null;
		relocate();

	}

	public Tribe getActiveTribe() {
		return this.activeTribe;
	}

	public Tribe getDeclinedTribe() {
		return this.inDeclineTribe;
	}

	private void relocate() {

		Vector2 vector2 = Credentials.INSTANCE.cTribesPlayer.clone();

		if (this.activeTribe != null) {

			this.activeTribe.relocateTopLeft(vector2);
			vector2.addY(
					Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		}

		if (this.inDeclineTribe != null) {

			this.inDeclineTribe.relocateTopLeft(vector2);
			vector2.addY(
					Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		}

	}

}
