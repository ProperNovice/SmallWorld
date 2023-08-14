package tokens;

import enums.ELayerZ;
import enums.ETokenSize;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class GamePiece implements IImageViewAble {

	public GamePiece() {

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
