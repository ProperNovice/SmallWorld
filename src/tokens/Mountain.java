package tokens;

import enums.ELayerZ;
import enums.ETokenSize;

public class Mountain extends Token {

	@Override
	protected ETokenSize getETokenSize() {
		return ETokenSize.BIG;
	}

	@Override
	protected ELayerZ getELayerZ() {
		return ELayerZ.MOUNTAINS;
	}

}
