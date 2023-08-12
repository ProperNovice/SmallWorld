package listCredentials;

import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;

public class ListRegionLinear extends ListCredentials {

	public ListRegionLinear() {

		super.objectsPerRow = 3;
		super.relocateTypeEnum = RelocateTypeEnum.CENTER;
		super.rearrangeTypeEnum = RearrangeTypeEnum.PIVOT;

	}

}
