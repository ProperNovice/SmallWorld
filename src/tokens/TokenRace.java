package tokens;

import races.Race;

public class TokenRace extends Token {

	private Class<? extends Race> classRace = null;

	public TokenRace(Class<? extends Race> classRace) {

		this.classRace = classRace;
		super.createImageView();

	}

	@Override
	protected String getFileName() {
		return "races/" + this.classRace.getSimpleName();
	}

}
