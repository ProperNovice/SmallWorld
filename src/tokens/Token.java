package tokens;

import enums.ELayerZ;
import enums.ETokenSize;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Token implements IImageViewAble {

	public Token() {

		if (!(this instanceof TokenRace))
			createImageView();

	}

	protected final void createImageView() {

		String fileName = "";
		fileName += "tokens/";
		fileName += getFileName();
		fileName += ".png";

		new ImageView(fileName, getELayerZ(), this);
		getImageView().setWidth(getETokenSize().size());

	}

	protected String getFileName() {
		return this.getClass().getSimpleName();
	}

	protected ETokenSize getETokenSize() {
		return ETokenSize.SMALL;
	}

	protected ELayerZ getELayerZ() {
		return ELayerZ.TOKENS;
	}

}
