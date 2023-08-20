package tokens;

import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Token implements IImageViewAble {

	public Token() {

	}

	protected final void createImageView() {

		String fileName = "";
		fileName += "tokens/";
		fileName += getFileName();
		fileName += ".png";

		new ImageView(fileName, getELayerZ(), this);
		getImageView().setVisible(false);

	}

	protected abstract String getFileName();

	protected ELayerZ getELayerZ() {
		return ELayerZ.TOKENS;
	}

}
