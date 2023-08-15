package gameStates;

import enums.EPlayer;
import enums.ERegionType;
import enums.EToken;
import gameStatesDefault.GameState;
import managers.CoinManager;
import maps.Map;
import maps.MapVanilla2;
import model.Region;
import tokens.TokenNonRace;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Map map = new MapVanilla2();

		for (Region region : map.getRegions()) {

			if (region.getERegionType().equals(ERegionType.MOUNTAIN))
				region.addTokenStaticRelocate(new TokenNonRace(EToken.MOUNTAIN));

			if (region.hasLostTribeSymbol())
				region.addTokenLinearRelocate(new TokenNonRace(EToken.LOSTTRIBES));

		}

		CoinManager.INSTANCE.addCoins(EPlayer.BOT, 19);
		CoinManager.INSTANCE.addCoins(EPlayer.I, 10);
		CoinManager.INSTANCE.addCoins(EPlayer.BOT, 2);
		CoinManager.INSTANCE.addCoins(EPlayer.I, 15);
		CoinManager.INSTANCE.addCoins(EPlayer.BOT, 4);

	}

}
