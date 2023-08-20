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

		ArrayList<Token> listMap = this.mapTokenRace.getValue(eRace);
		ArrayList<Token> listToReturn = new ArrayList<>();

		for (Token token : listMap) {

			if (token.getImageView().isVisible())
				continue;

			token.getImageView().setVisible(true);
			listToReturn.addLast(token);

			if (listToReturn.size() == tokensNeeded)
				break;

		}

		while (listToReturn.size() < tokensNeeded) {

			Token token = new TokenRace(eRace);
			listMap.addLast(token);
			listToReturn.addLast(token);

		}

		return listToReturn;

	}

	public ArrayList<Token> getTokensNonRace(EToken eToken, int tokensNeeded) {

		if (!this.mapTokenNonRace.containsKey(eToken))
			this.mapTokenNonRace.put(eToken, new ArrayList<>());

		ArrayList<Token> listMap = this.mapTokenNonRace.getValue(eToken);
		ArrayList<Token> listToReturn = new ArrayList<>();

		for (Token token : listMap) {

			if (token.getImageView().isVisible())
				continue;

			token.getImageView().setVisible(true);
			listToReturn.addLast(token);

			if (listToReturn.size() == tokensNeeded)
				break;

		}

		while (listToReturn.size() < tokensNeeded) {

			Token token = new TokenNonRace(eToken);
			listMap.addLast(token);
			listToReturn.addLast(token);

		}

		return listToReturn;

	}

}
