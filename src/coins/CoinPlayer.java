package coins;

public class CoinPlayer extends Coin {

	public CoinPlayer(int value) {
		super(value);
	}

	@Override
	protected String getFolder() {
		return "player";
	}

}
