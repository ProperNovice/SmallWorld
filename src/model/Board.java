package model;

import enums.ELayerZ;
import managers.Credentials;
import managers.RacesManager;
import managers.SpecialPowersManager;
import utils.ArrayList;
import utils.Background;

public enum Board {

	INSTANCE;

	private ArrayList<Tribe> list = new ArrayList<>(5);
	private Background background = new Background(ELayerZ.RACES_SPECIAL_POWERS);

	private Board() {
		this.background.getImageView().setVisible(false);
	}

	public void fill() {

		if (this.list.isMaxCapacity())
			return;

		Race race = RacesManager.INSTANCE.getRandomRace();
		SpecialPower specialPower = SpecialPowersManager.INSTANCE.getRandomSpecialPower();
		Tribe raceSpecialPower = new Tribe(race, specialPower);

		this.list.addLast(raceSpecialPower);

		if (!this.list.isMaxCapacity())
			fill();

	}

	public void show() {

		this.background.getImageView().setVisible(true);

		double centerX = Credentials.INSTANCE.dFrame.x / 2;

		double centerY = Credentials.INSTANCE.dFrame.y / 2;
		centerY += 2
				* (Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

		for (Tribe raceSpecialPower : this.list) {

			int index = this.list.indexOf(raceSpecialPower);
			double y = centerY - index
					* (Credentials.INSTANCE.dRace.y + Credentials.INSTANCE.dGapBetweenComponents.y);

			raceSpecialPower.relocateCenter(centerX, y);

		}

	}

	public void hide() {

		this.background.getImageView().setVisible(false);

		for (Tribe raceSpecialPower : this.list) {

			raceSpecialPower.getRace().getImageView().setVisible(false);
			raceSpecialPower.getSpecialPower().getImageView().setVisible(false);

		}

	}

	public void removeRaceSpecialPower(Tribe raceSpecialPower) {
		this.list.remove(raceSpecialPower);
	}

}
