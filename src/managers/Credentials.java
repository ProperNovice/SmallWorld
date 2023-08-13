package managers;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "Small World", numbersImageViewColor = "black";
	public final boolean colliderVisibility = true;
	public final double gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = 100, animationStep = 4;
	public Vector2 dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewIndicator;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public Vector2 cMap;
	public Vector2 dSpecialPower, dRace;
	public double gapBetweenRaceAndSpecialPower;

	private Credentials() {

		double x = 0, y = 0;

		this.dFrame = new Vector2(2560 - 4, 1368);
		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// c text panel

		this.cTextPanel = new Vector2(x, y);

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewIndicator = new Vector2(x, y);

		// c map

		x = this.gapBetweenBorders;
		this.cMap = new Vector2(x, x);

		// gapBetweenRaceAndSpecialPower

		this.gapBetweenRaceAndSpecialPower = 170;

		// d special power

		x = 229;
		y = 228;
		this.dSpecialPower = new Vector2(x, y);

		// d race

		y = 228;
		x = 439 * this.dSpecialPower.y / 233;
		this.dRace = new Vector2(x, y);

	}

}
