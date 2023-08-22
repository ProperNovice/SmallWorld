package managers;

import enums.ETokenSize;
import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "Small World", numbersImageViewColor = "black";
	public final boolean colliderVisibility = true;
	public final double gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = ETokenSize.SMALL.getSize(), animationStep = 4;
	public Vector2 dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewIndicator;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public Vector2 cMap, cCoins, cTribesPlayer, cTokensHuman, cTokensBot;
	public Vector2 dSpecialPower, dRace, dCoin, dMap;
	public double gapBetweenTribesRaceAndSpecialPower;

	private Credentials() {

		double x = 0, y = 0;

		this.dFrame = new Vector2(2560 - 4, 1368);
		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewIndicator = new Vector2(x, y);

		// c map

		x = this.gapBetweenBorders;
		this.cMap = new Vector2(x, x);

		// c map

		x = 2030;
		y = 1318;
		this.dMap = new Vector2(x, y);

		// race and special power dimensions

		handleRaceAndSpecialPowerDimensions();

		// c coin

		x = this.gapBetweenBorders;
		x += this.dMap.x;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		this.cCoins = new Vector2(x, y);

		// d coin

		x = this.dFrame.x;
		x -= 2 * this.gapBetweenBorders;
		x -= this.dMap.x;
		x -= this.dGapBetweenComponents.x;
		x /= 4;
		y = 413 * x / 423;
		this.dCoin = new Vector2(x, y);

		// c tokens human

		x = this.cCoins.x;
		y = this.gapBetweenBorders;
		y += this.dCoin.y;
		y += this.dGapBetweenComponents.y;
		this.cTokensHuman = new Vector2(x, y);

		// c tokens bot

		x = this.cTokensHuman.x;
		y = this.cTokensHuman.y;
		y += ETokenSize.SMALL.getSize();
		y += this.dGapBetweenComponents.y;
		this.cTokensBot = new Vector2(x, y);

		// c race and special power

		x = this.cCoins.x;
		y = this.cTokensBot.y;
		y += ETokenSize.SMALL.getSize();
		y += this.dGapBetweenComponents.y;
		this.cTribesPlayer = new Vector2(x, y);

		// c text panel

		x = this.cMap.x;
		x += this.dMap.x;
		x += this.dGapBetweenComponents.x;
		y = 600;
		this.cTextPanel = new Vector2(x, y);

	}

	private void handleRaceAndSpecialPowerDimensions() {

		double scale = 1;
		double totalX = this.dFrame.x;
		totalX -= 2 * this.gapBetweenBorders;
		totalX -= this.dMap.x;
		totalX -= this.dGapBetweenComponents.x;

		while (true) {

			double x, y;

			// d special power

			x = 229;
			y = 228;
			this.dSpecialPower = new Vector2(x * scale, y * scale);

			// gapBetweenRaceAndSpecialPower

			this.gapBetweenTribesRaceAndSpecialPower = 170 * scale;

			// d race

			y = this.dSpecialPower.y;
			x = 439 * this.dSpecialPower.y / 233;
			this.dRace = new Vector2(x, y);

			double raceAndSpecialPowerX = this.gapBetweenTribesRaceAndSpecialPower;
			raceAndSpecialPowerX += this.dRace.x;

			if (raceAndSpecialPowerX <= totalX)
				break;

			scale -= 0.001;

		}

	}

}
