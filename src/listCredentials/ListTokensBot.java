package listCredentials;

import managers.Credentials;

public class ListTokensBot extends ListCredentials {

	public ListTokensBot() {

		super.coordinatesList = Credentials.INSTANCE.cTokensBot;

	}

}
