package coins;

import managers.Credentials;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class CoinBack implements IImageViewAble {

	public CoinBack() {

		String filePath = "coins/";
		filePath += getFolderPath();
		filePath += "/back.png";

		new ImageView(filePath, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCoin);
		getImageView().setVisible(false);

	}

	protected abstract String getFolderPath();

}
