package model;

import enums.ERegionType;
import utils.ShutDown;
import utils.Vector2;

public class RegionBuilder {

	private ERegionType eRegionType = null;
	private boolean hasMine = false, isMagic = false, hasCavern = false, hasLostTribeSymbol = false;
	private Vector2 coordinates = null;

	public RegionBuilder() {

	}

	public RegionBuilder regionType(ERegionType eRegionType) {
		this.eRegionType = eRegionType;
		return this;
	}

	public RegionBuilder hasMine() {
		this.hasMine = true;
		return this;
	}

	public RegionBuilder isMagic() {
		this.isMagic = true;
		return this;
	}

	public RegionBuilder hasCavern() {
		this.hasCavern = true;
		return this;
	}

	public RegionBuilder hasLostTribeSymbol() {
		this.hasLostTribeSymbol = true;
		return this;
	}

	public RegionBuilder coordinates(double x, double y) {
		this.coordinates = new Vector2(x, y);
		return this;
	}

	public Region build() {

		if (this.eRegionType == null || this.coordinates == null)
			ShutDown.INSTANCE.execute();

		return new Region(this.eRegionType, this.hasMine, this.isMagic, this.hasCavern,
				this.hasLostTribeSymbol, this.coordinates);

	}

}
