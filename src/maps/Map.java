package maps;

import enums.ELayerZ;
import managers.Credentials;
import model.Region;
import utils.ArrayList;
import utils.HashMap;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Map implements IImageViewAble {

	protected final ArrayList<Region> regions = new ArrayList<>();
	protected final HashMap<Region, ArrayList<Region>> adjacencies = new HashMap<>();

	public Map() {

		createMapImageView();
		createRegions();
		createAdjacencies();

	}

	private void createMapImageView() {

		String fileName = "";
		fileName += "maps/";
		fileName += this.getClass().getSimpleName();
		fileName += ".png";

		new ImageView(fileName, ELayerZ.MAP, this);
		getImageView().relocateTopLeft(Credentials.INSTANCE.cMap);

	}

	protected abstract void createRegions();

	protected abstract void createAdjacencies();

	protected final void addAdjecents(int regionIntA, int regionIntB) {

		Region regionA = this.regions.get(regionIntA);
		Region regionB = this.regions.get(regionIntB);

		if (!this.adjacencies.containsKey(regionA))
			this.adjacencies.put(regionA, new ArrayList<>());

		if (!this.adjacencies.containsKey(regionB))
			this.adjacencies.put(regionB, new ArrayList<>());

		this.adjacencies.getValue(regionA).addLast(regionB);
		this.adjacencies.getValue(regionB).addLast(regionA);

	}

	public final ArrayList<Region> getRegions() {
		return this.regions;
	}

	public final ArrayList<Region> getAdjecencies(Region region) {
		return this.adjacencies.getValue(region);
	}

}
