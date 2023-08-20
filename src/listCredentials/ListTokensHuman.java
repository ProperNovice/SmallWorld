package listCredentials;

import managers.Credentials;

public class ListTokensHuman extends ListCredentials {

	public ListTokensHuman() {

		super.coordinatesList = Credentials.INSTANCE.cTokensHuman;

	}

}
