package model;

import enums.ELayerZ;
import enums.ESpecialPower;
import managers.Credentials;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Logger;

public class SpecialPower implements IImageViewAble {

	private ESpecialPower eSpecialPower = null;

	public SpecialPower(ESpecialPower eSpecialPower) {

		this.eSpecialPower = eSpecialPower;

		String fileName = "specialPowers/";
		fileName += this.eSpecialPower.toString();
		fileName += ".png";

		new ImageView(fileName, ELayerZ.RACES_SPECIAL_POWERS, this);

		getImageView().setDimensions(Credentials.INSTANCE.dSpecialPower);

	}

	public void print() {
		Logger.INSTANCE.logNewLine(this.eSpecialPower.toString().toLowerCase() + " -> "
				+ this.eSpecialPower.getValue());
	}

	public ESpecialPower getESpecialPower() {
		return this.eSpecialPower;
	}

}
