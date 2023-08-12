package specialPowers;

import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class SpecialPower implements IImageViewAble {

	public SpecialPower() {

		String fileName = "special powers/";
		fileName += this.getClass().getSimpleName();
		fileName += ".png";

		new ImageView(fileName, this);

	}

	public abstract int getValue();

}
