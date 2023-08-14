package tokens;

import enums.EToken;

public class TokenNonRace extends Token {

	private EToken eGamePiece = null;

	public TokenNonRace(EToken eGamePiece) {

		this.eGamePiece = eGamePiece;
		super.createImageView();
		getImageView().setWidth(this.eGamePiece.getETokenSize().getSize());

	}

	@Override
	protected String getFileName() {
		return this.eGamePiece.toString().toLowerCase();
	}

}
