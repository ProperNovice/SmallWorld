package races;

import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Race implements IImageViewAble {

	public Race() {

		String fileNameFront = "races/", fileNameBack = fileNameFront;

		fileNameFront += "front/";
		fileNameBack += "back/";

		fileNameFront += this.getClass().getSimpleName();
		fileNameBack += this.getClass().getSimpleName();

		fileNameFront += ".png";
		fileNameBack += ".png";

		new ImageView(fileNameFront, this);
		getImageView().setBack(fileNameBack);

	}

	public abstract int getValue();

}
