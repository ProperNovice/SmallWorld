package model;

import managers.Credentials;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.Vector2;

public class Tribe implements ISelectCoordinatesAble {

	private Race race = null;
	private SpecialPower specialPower = null;

	public Tribe(Race race, SpecialPower specialPower) {

		this.race = race;
		this.specialPower = specialPower;

	}

	public Race getRace() {
		return this.race;
	}

	public SpecialPower getSpecialPower() {
		return this.specialPower;
	}

	public void relocateCenter(double x, double y) {

		double totalX = Credentials.INSTANCE.gapBetweenTribesRaceAndSpecialPower
				+ Credentials.INSTANCE.dRace.x;

		double topLeftX = x - totalX / 2;
		double topLeftY = y - Credentials.INSTANCE.dRace.y / 2;

		relocateTopLeft(topLeftX, topLeftY);

	}

	public void relocateTopLeft(double x, double y) {

		this.specialPower.getImageView().relocateTopLeft(x, y);

		double gapX = Credentials.INSTANCE.gapBetweenTribesRaceAndSpecialPower;
		this.race.getImageView().relocateTopLeft(x + gapX, y);

	}

	public void relocateTopLeft(Vector2 vector2) {
		relocateTopLeft(vector2.x, vector2.y);
	}

	@Override
	public Vector2 getSelectCoordinatesCenter() {

		double x = this.specialPower.getImageView().getCoordinatesTopLeftX();
		x += Credentials.INSTANCE.gapBetweenTribesRaceAndSpecialPower / 2;
		x += Credentials.INSTANCE.dRace.x / 2;

		double y = this.race.getImageView().getCoordinatesCenterY();

		return new Vector2(x, y);

	}

}
