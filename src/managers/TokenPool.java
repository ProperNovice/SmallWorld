package managers;

import enums.ERace;
import enums.EToken;
import tokens.Token;
import tokens.TokenNonRace;
import tokens.TokenRace;
import utils.ArrayList;
import utils.HashMap;

public enum TokenPool {

	INSTANCE;

	private HashMap<EToken, ArrayList<Token>> mapTokenNonRace = new HashMap<>();
	private HashMap<ERace, ArrayList<Token>> mapTokenRace = new HashMap<>();

	private TokenPool() {

	}

	public ArrayList<Token> getTokensRace(ERace eRace, int tokensNeeded) {

		if (!this.mapTokenRace.containsKey(eRace))
			this.mapTokenRace.put(eRace, new ArrayList<>());

		int tokensAvailable = 0;

		ArrayList<Token> listMap = this.mapTokenRace.getValue(eRace);
		ArrayList<Token> listToReturn = new ArrayList<>();

		// tokens available

		for (Token token : listMap)
			if (!token.getImageView().isVisible())
				tokensAvailable++;

		// create tokens if necessary

		for (int counter = tokensAvailable; counter < tokensNeeded; counter++)
			listMap.addLast(new TokenRace(eRace));

		// create tokens to return

		for (Token token : listMap)
			if (!token.getImageView().isVisible()) {
				listToReturn.addLast(token);
				token.getImageView().setVisible(true);
			}

		return listToReturn;

	}

	public ArrayList<Token> getTokensNonRace(EToken eToken, int tokensNeeded) {

		if (!this.mapTokenNonRace.containsKey(eToken))
			this.mapTokenNonRace.put(eToken, new ArrayList<>());

		int tokensAvailable = 0;

		ArrayList<Token> listMap = this.mapTokenNonRace.getValue(eToken);
		ArrayList<Token> listToReturn = new ArrayList<>();

		// tokens available

		for (Token token : listMap)
			if (!token.getImageView().isVisible())
				tokensAvailable++;

		// create tokens if necessary

		for (int counter = tokensAvailable; counter < tokensNeeded; counter++)
			listMap.addLast(new TokenNonRace(eToken));

		// create tokens to return

		for (Token token : listMap)
			if (!token.getImageView().isVisible()) {
				listToReturn.addLast(token);
				token.getImageView().setVisible(true);
			}

		return listToReturn;

	}

}
