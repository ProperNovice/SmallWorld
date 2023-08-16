package tokens;

import enums.EToken;

public class TokenNonRace extends Token {

	private EToken eToken = null;

	public TokenNonRace(EToken eToken) {

		this.eToken = eToken;
		super.createImageView();
		getImageView().setWidth(this.eToken.getETokenSize().getSize());

	}

	@Override
	protected String getFileName() {
		return this.eToken.toString().toLowerCase();
	}

}
