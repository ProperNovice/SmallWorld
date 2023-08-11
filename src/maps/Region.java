package maps;

import enums.ERegionType;
import managers.Credentials;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.Vector2;

public class Region implements ISelectCoordinatesAble {

	private ERegionType eRegionType = null;
	private boolean hasMine = false, isMagic = false, hasCavern = false, hasLostTribeSymbol = false;
	private Vector2 coordinates = null;

	public Region(ERegionType eRegionType, boolean hasMine, boolean isMagic, boolean hasCavern,
			boolean hasLostTribeSymbol, Vector2 coordinates) {

		this.eRegionType = eRegionType;
		this.hasMine = hasMine;
		this.isMagic = isMagic;
		this.hasCavern = hasCavern;
		this.hasLostTribeSymbol = hasLostTribeSymbol;
		this.coordinates = coordinates;

		this.coordinates.addVector2(Credentials.INSTANCE.cMap);

	}

	public ERegionType getERegionType() {
		return this.eRegionType;
	}

	public boolean hasMine() {
		return this.hasMine;
	}

	public boolean isMagic() {
		return this.isMagic;
	}

	public boolean hasCavern() {
		return this.hasCavern;
	}

	public boolean hasLostTribeSymbol() {
		return this.hasLostTribeSymbol;
	}

	public Vector2 getCoordinates() {
		return this.coordinates;
	}

	@Override
	public Vector2 getSelectCoordinatesCenter() {
		return this.coordinates;
	}

}
