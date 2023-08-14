package enums;

public enum ESpecialPower {

	ALCHEMIST(4), AQUATIC(3), BARRICADE(4), BEHEMOTH(4), BERSERK(4), BIVOUACKING(5), CATAPULT(4),
	COMMANDO(4), COPYCAT(3), CORRUPT(4), CURSED(0), DIPLOMAT(5), DRAGONMASTER(5), FIREBALL(5),
	FLYING(5), FOREST(4), FORTIFIED(3), HEROIC(5), HILL(4), HISTORIAN(5), HORDESOF(5), IMPERIAL(4),
	LAVA(5), MARAUDING(5), MERCENARY(4), MERCHANT(2), MOUNTED(5), PEACELOVING(4), PILLAGING(5),
	RANSACKING(4), SEAFARING(5), SOULTOUCH(4), SPIRIT(5), STOUT(4), SWAMP(4), UNDERWORLD(5),
	WEALTHY(4), WERE(4);

	private int value = -1;

	private ESpecialPower(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
