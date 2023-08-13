package model;

import enums.ELayerZ;
import enums.ERace;
import managers.Credentials;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Race implements IImageViewAble {

	private ERace eRace = null;

	public Race(ERace eRace) {

		this.eRace = eRace;

		String fileNameFront = "races/", fileNameBack = fileNameFront;

		fileNameFront += "front/";
		fileNameBack += "back/";

		fileNameFront += this.eRace.toString();
		fileNameBack += this.eRace.toString();

		fileNameFront += ".png";
		fileNameBack += ".png";

		new ImageView(fileNameFront, ELayerZ.RACES_SPECIAL_POWERS, this);
		getImageView().setBack(fileNameBack);

		getImageView().setDimensions(Credentials.INSTANCE.dRace);

	}

	public ERace getERace() {
		return this.eRace;
	}

}
