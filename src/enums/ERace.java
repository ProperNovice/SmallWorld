package enums;

public enum ERace {

	AMAZONS(6), BARBARIANS(9), DWARVES(3), ELVES(6), FAUNS(5), GHOULS(5), GIANTS(6), GOBLINS(6),
	GYPSIES(6), HALFLINGS(6), HUMANS(5), HUMUNCULI(5), ICEWITCHES(5), IGORS(4), KOBOLDS(11),
	LEPRECHAUNS(6), ORCS(5), PIXIES(11), PRIESTESSESS(4), PYGMIES(6), RATMEN(8), SHRUBMEN(6),
	SKAGS(6), SKELETONS(6), SLINGMEN(5), SORCERERS(5), TRITONS(6), TROLLS(5), WHITELADIES(2),
	WIZARDS(5);

	private int value = -1;

	private ERace(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
