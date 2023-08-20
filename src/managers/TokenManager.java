package managers;

import enums.EPlayer;
import enums.ETokenSize;
import listCredentials.ListTokensBot;
import listCredentials.ListTokensHuman;
import tokens.Token;
import utils.ArrayList;
import utils.HashMap;
import utils.ListImageViewAbles;

public enum TokenManager {

	INSTANCE;

	private HashMap<EPlayer, ListImageViewAbles<Token>> map = new HashMap<>();

	private TokenManager() {

		this.map.put(EPlayer.HUMAN, new ListImageViewAbles<>(ListTokensHuman.class));
		this.map.put(EPlayer.BOT, new ListImageViewAbles<>(ListTokensBot.class));

	}

	public ArrayList<Token> getTokens(EPlayer ePlayer, int amount, boolean relocate) {

		ArrayList<Token> tokens = new ArrayList<>();

		while (tokens.size() < amount)
			tokens.addLast(map.getValue(ePlayer).getArrayList().removeLast());

		if (relocate)
			relocateTokens(ePlayer);

		return tokens;

	}

	public int getTokenSizeAvailable(EPlayer ePlayer) {
		return this.map.getValue(ePlayer).getArrayList().size();
	}

	public void addTokens(EPlayer ePlayer, ArrayList<Token> tokens) {

		ListImageViewAbles<Token> listImageViewAbles = this.map.getValue(ePlayer);
		listImageViewAbles.getArrayList().addAllLast(tokens);
		relocateTokens(ePlayer);

	}

	private void relocateTokens(EPlayer ePlayer) {

		ListImageViewAbles<Token> listImageViewAbles = this.map.getValue(ePlayer);

		double totalX = Credentials.INSTANCE.dFrame.x;
		totalX -= 2 * Credentials.INSTANCE.gapBetweenBorders;
		totalX -= Credentials.INSTANCE.dMap.x;
		totalX -= Credentials.INSTANCE.dGapBetweenComponents.x;

		double gapOriginal = ETokenSize.SMALL.getSize()
				+ Credentials.INSTANCE.dGapBetweenComponents.x;

		double gapX = totalX;
		gapX -= ETokenSize.SMALL.getSize();
		gapX /= listImageViewAbles.getArrayList().size() - 1;

		gapX = Math.min(gapOriginal, gapX);

		listImageViewAbles.getListCredentials().gapBetweenComponents.x = gapX;
		listImageViewAbles.relocateImageViews();

	}

}
