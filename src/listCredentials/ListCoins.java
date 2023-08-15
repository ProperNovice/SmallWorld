package listCredentials;

import managers.Credentials;

public class ListCoins extends ListCredentials {

	public ListCoins() {

		super.coordinatesList = Credentials.INSTANCE.cCoins;

	}

}
