package coins;

public class CoinBot extends Coin {

	public CoinBot(int value) {
		super(value);
	}

	@Override
	protected String getFolder() {
		return "bot";
	}

}
