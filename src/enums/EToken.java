package enums;

public enum EToken {

	MOUNTAIN(ETokenSize.BIG), LOSTTRIBES(ETokenSize.SMALL);

	private ETokenSize eTokenSize = null;

	private EToken(ETokenSize eTokenSize) {
		this.eTokenSize = eTokenSize;
	}
	
	public ETokenSize getETokenSize() {
		return this.eTokenSize;
	}

}
