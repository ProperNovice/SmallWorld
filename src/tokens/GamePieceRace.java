package tokens;

import model.Race;

public class GamePieceRace extends GamePiece {

	private Class<? extends Race> classRace = null;

	public GamePieceRace(Class<? extends Race> classRace) {

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
