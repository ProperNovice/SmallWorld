package coins;

import managers.Credentials;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Coin implements IImageViewAble {

	private int value = -1;

	public Coin(int value) {

		this.value = value;

		String filePath = "coins/";
		filePath += getFolder() + "/";
		filePath += this.value;
		filePath += ".png";

		new ImageView(filePath, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCoin);
		getImageView().setVisible(false);

	}

	protected abstract String getFolder();

}
