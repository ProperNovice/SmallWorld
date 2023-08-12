package model;

import enums.ERegionType;
import listCredentials.ListRegionLinear;
import listCredentials.ListRegionStatic;
import managers.Credentials;
import tokens.Token;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.ListImageViewAbles;
import utils.Logger;
import utils.Vector2;

public class Region implements ISelectCoordinatesAble {

	private ERegionType eRegionType = null;
	private boolean hasMine = false, isMagic = false, hasCavern = false, hasLostTribeSymbol = false;
	private Vector2 coordinates = null;
	public ListImageViewAbles<Token> listLinear = new ListImageViewAbles<>(ListRegionLinear.class);
	public ListImageViewAbles<Token> listStatic = new ListImageViewAbles<>(ListRegionStatic.class);

	public Region(ERegionType eRegionType, boolean hasMine, boolean isMagic, boolean hasCavern,
			boolean hasLostTribeSymbol, Vector2 coordinates) {

		this.eRegionType = eRegionType;
		this.hasMine = hasMine;
		this.isMagic = isMagic;
		this.hasCavern = hasCavern;
		this.hasLostTribeSymbol = hasLostTribeSymbol;
		this.coordinates = coordinates;

		this.coordinates.addVector2(Credentials.INSTANCE.cMap);
		this.listLinear.getListCredentials().coordinatesList = this.coordinates;
		this.listStatic.getListCredentials().coordinatesList = this.coordinates;

	}

	public void addTokenLinearRelocate(Token token) {

		this.listLinear.getArrayList().addLast(token);
		this.listLinear.relocateImageViews();

	}

	public void addTokenStaticRelocate(Token token) {

		this.listStatic.getArrayList().addLast(token);
		this.listStatic.relocateImageViews();

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

	public void print() {

		Logger.INSTANCE.log("printint region");
		Logger.INSTANCE.log(this.eRegionType);

		if (this.hasMine)
			Logger.INSTANCE.log("has mine");
		if (this.isMagic)
			Logger.INSTANCE.log("is magic");
		if (this.hasCavern)
			Logger.INSTANCE.log("has cavern");
		if (this.hasLostTribeSymbol)
			Logger.INSTANCE.log("has Lost Tribe symbol");

		Logger.INSTANCE.newLine();

	}

}
