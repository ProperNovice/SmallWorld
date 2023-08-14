package enums;

public enum ETokenSize {

	BIG(240), MEDIUM(120), SMALL(80);

	private double size = -1;

	private ETokenSize(double size) {
		this.size = size;
	}

	public double getSize() {
		return this.size;
	}

}
