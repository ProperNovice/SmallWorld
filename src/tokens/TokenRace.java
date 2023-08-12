package tokens;

import races.Race;

public class TokenRace extends Token {

	private Class<? extends Race> classRace = null;

	public TokenRace(Class<? extends Race> classRace) {

		this.classRace = classRace;
		super.createImageView();
		createBack();

	}

	private void createBack() {

		String fileName = "";
		fileName += "tokens/races/back/";
		fileName += this.classRace.getSimpleName();
		fileName += ".png";

		getImageView().setBack(fileName);

	}

	@Override
	protected String getFileName() {
		return "races/front/" + this.classRace.getSimpleName();
	}

}
