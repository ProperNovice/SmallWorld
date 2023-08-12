package maps;

import enums.ERegionType;
import regions.RegionBuilder;

public class MapVanilla2 extends Map {

	@Override
	protected void createRegions() {

		// 0

		super.regions.addLast(
				new RegionBuilder().coordinates(208, 124).regionType(ERegionType.SEA).build());

		// 1

		super.regions.addLast(new RegionBuilder().coordinates(604, 182)
				.regionType(ERegionType.FARMLAND).isMagic().build());

		// 2

		super.regions.addLast(new RegionBuilder().coordinates(914, 146)
				.regionType(ERegionType.FOREST).hasMine().build());

		// 3

		super.regions.addLast(new RegionBuilder().coordinates(1263, 179)
				.regionType(ERegionType.SWAMP).hasCavern().hasLostTribeSymbol().build());

		// 4

		super.regions.addLast(
				new RegionBuilder().coordinates(1771, 151).regionType(ERegionType.HILL).build());

		// 5

		super.regions.addLast(new RegionBuilder().coordinates(245, 472)
				.regionType(ERegionType.MOUNTAIN).hasMine().hasCavern().build());

		// 6

		super.regions.addLast(new RegionBuilder().coordinates(680, 518).regionType(ERegionType.HILL)
				.hasLostTribeSymbol().build());

		// 7

		super.regions.addLast(
				new RegionBuilder().coordinates(982, 622).regionType(ERegionType.LAKE).build());

		// 8

		super.regions.addLast(new RegionBuilder().coordinates(1219, 451)
				.regionType(ERegionType.MOUNTAIN).build());

		// 9

		super.regions.addLast(new RegionBuilder().coordinates(1499, 373)
				.regionType(ERegionType.FARMLAND).build());

		// 10

		super.regions.addLast(new RegionBuilder().coordinates(1840, 437)
				.regionType(ERegionType.FOREST).isMagic().hasLostTribeSymbol().build());

		// 11

		super.regions.addLast(new RegionBuilder().coordinates(247, 761)
				.regionType(ERegionType.FARMLAND).hasLostTribeSymbol().build());

		// 12

		super.regions.addLast(new RegionBuilder().coordinates(743, 833)
				.regionType(ERegionType.FOREST).hasLostTribeSymbol().build());

		// 13

		super.regions.addLast(new RegionBuilder().coordinates(1221, 847)
				.regionType(ERegionType.FARMLAND).isMagic().hasLostTribeSymbol().build());

		// 14

		super.regions.addLast(new RegionBuilder().coordinates(1536, 697)
				.regionType(ERegionType.HILL).hasCavern().hasLostTribeSymbol().build());

		// 15

		super.regions.addLast(new RegionBuilder().coordinates(1904, 679)
				.regionType(ERegionType.MOUNTAIN).hasMine().build());

		// 16

		super.regions.addLast(new RegionBuilder().coordinates(158, 1059)
				.regionType(ERegionType.SWAMP).isMagic().hasLostTribeSymbol().build());

		// 17

		super.regions.addLast(new RegionBuilder().coordinates(542, 1078)
				.regionType(ERegionType.HILL).hasCavern().build());

		// 18

		super.regions.addLast(new RegionBuilder().coordinates(917, 1140)
				.regionType(ERegionType.SWAMP).hasMine().hasLostTribeSymbol().build());

		// 19

		super.regions.addLast(new RegionBuilder().coordinates(1215, 1155)
				.regionType(ERegionType.MOUNTAIN).build());

		// 20

		super.regions.addLast(
				new RegionBuilder().coordinates(1487, 1032).regionType(ERegionType.SWAMP).build());

		// 21

		super.regions.addLast(
				new RegionBuilder().coordinates(1748, 925).regionType(ERegionType.FOREST).build());

		// 22

		super.regions.addLast(
				new RegionBuilder().coordinates(1830, 1191).regionType(ERegionType.SEA).build());

	}

	@Override
	protected void createAdjacencies() {

		super.addAdjecents(0, 1);
		super.addAdjecents(0, 5);
		super.addAdjecents(1, 2);
		super.addAdjecents(1, 5);
		super.addAdjecents(1, 6);
		super.addAdjecents(2, 3);
		super.addAdjecents(2, 6);
		super.addAdjecents(2, 7);
		super.addAdjecents(2, 8);
		super.addAdjecents(3, 4);
		super.addAdjecents(3, 8);
		super.addAdjecents(3, 9);
		super.addAdjecents(4, 9);
		super.addAdjecents(4, 10);
		super.addAdjecents(5, 6);
		super.addAdjecents(5, 11);
		super.addAdjecents(6, 7);
		super.addAdjecents(6, 11);
		super.addAdjecents(6, 12);
		super.addAdjecents(7, 8);
		super.addAdjecents(7, 12);
		super.addAdjecents(7, 13);
		super.addAdjecents(8, 9);
		super.addAdjecents(8, 13);
		super.addAdjecents(8, 14);
		super.addAdjecents(9, 10);
		super.addAdjecents(9, 14);
		super.addAdjecents(10, 14);
		super.addAdjecents(10, 15);
		super.addAdjecents(11, 12);
		super.addAdjecents(11, 16);
		super.addAdjecents(11, 17);
		super.addAdjecents(12, 13);
		super.addAdjecents(12, 17);
		super.addAdjecents(12, 18);
		super.addAdjecents(13, 14);
		super.addAdjecents(13, 18);
		super.addAdjecents(13, 19);
		super.addAdjecents(13, 20);
		super.addAdjecents(14, 15);
		super.addAdjecents(14, 20);
		super.addAdjecents(14, 21);
		super.addAdjecents(15, 21);
		super.addAdjecents(15, 22);
		super.addAdjecents(16, 17);
		super.addAdjecents(17, 18);
		super.addAdjecents(18, 19);
		super.addAdjecents(19, 20);
		super.addAdjecents(20, 21);
		super.addAdjecents(20, 22);
		super.addAdjecents(21, 22);

	}

}
