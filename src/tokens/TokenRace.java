package tokens;

import enums.ERace;
import enums.ETokenSize;

public class TokenRace extends Token {

	private ERace eRace = null;

	public TokenRace(ERace eRace) {

		this.eRace = eRace;
		super.createImageView();
		createBack();
		getImageView().setWidth(ETokenSize.SMALL.getSize());

	}

	private void createBack() {

		String fileName = "";
		fileName += "tokens/races/back/";
		fileName += this.eRace.toString().toLowerCase();
		fileName += ".png";

		getImageView().setBack(fileName);

	}

	@Override
	protected String getFileName() {
		return "races/front/" + this.eRace.toString().toLowerCase();
	}

}
