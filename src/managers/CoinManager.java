package managers;

import coins.Coin;
import coins.CoinBack;
import coins.CoinBackBot;
import coins.CoinBackPlayer;
import coins.CoinBot;
import coins.CoinPlayer;
import enums.EPlayer;
import listCredentials.ListCoins;
import utils.ArrayList;
import utils.HashMap;
import utils.ListImageViewAbles;
import utils.Logger;
import utils.Numeric;

public enum CoinManager {

	INSTANCE;

	private ListImageViewAbles<Coin> listCoinsNumeric = new ListImageViewAbles<>(ListCoins.class);
	private ListImageViewAbles<CoinBack> listCoinsBack = new ListImageViewAbles<>(ListCoins.class);
	private HashMap<EPlayer, HashMap<Integer, ArrayList<Coin>>> mapImageViews = new HashMap<>();
	private HashMap<EPlayer, Numeric> coins = new HashMap<>();

	private CoinManager() {

		createMapImageViews();
		createMapNumeric();

	}

	public void addCoins(EPlayer ePlayer, int coins) {

		this.coins.getValue(ePlayer).add(coins);

		int coinsDifference = this.coins.getValue(EPlayer.HUMAN).get()
				- this.coins.getValue(EPlayer.BOT).get();

		EPlayer ePlayerWinning = null;

		if (coinsDifference >= 0)
			ePlayerWinning = EPlayer.HUMAN;
		else
			ePlayerWinning = EPlayer.BOT;

		Logger.INSTANCE.log("coins difference -> " + coinsDifference);
		show(ePlayerWinning, Math.abs(coinsDifference));

	}

	private void show(EPlayer ePlayer, int coins) {

		// clear showing imageViews

		for (Coin coin : this.listCoinsNumeric)
			coin.getImageView().setVisible(false);

		this.listCoinsNumeric.getArrayList().clear();

		for (CoinBack coinBack : this.listCoinsBack)
			coinBack.getImageView().setVisible(false);

		// coins to show

		HashMap<Integer, Numeric> map = new HashMap<>();
		map.put(10, new Numeric(0));
		map.put(5, new Numeric(0));
		map.put(3, new Numeric(0));
		map.put(1, new Numeric(0));

		int denominations;

		denominations = getDenomination(coins, 10);
		map.getValue(10).add(denominations);
		coins -= 10 * denominations;

		denominations = getDenomination(coins, 5);
		map.getValue(5).add(denominations);
		coins -= 5 * denominations;

		denominations = getDenomination(coins, 3);
		map.getValue(3).add(denominations);
		coins -= 3 * denominations;

		denominations = getDenomination(coins, 1);
		map.getValue(1).add(denominations);
		coins -= 1 * denominations;

		Logger.INSTANCE.log("10 -> " + map.getValue(10).get());
		Logger.INSTANCE.log("5 -> " + map.getValue(5).get());
		Logger.INSTANCE.log("3 -> " + map.getValue(3).get());
		Logger.INSTANCE.log("1 -> " + map.getValue(1).get());
		Logger.INSTANCE.newLine();

		// populate list imageViews

		while (map.getValue(10).get() > 0) {

			ArrayList<Coin> arrayList = this.mapImageViews.getValue(ePlayer).getValue(10);
			Coin coin = arrayList.removeFirst();
			arrayList.addLast(coin);
			this.listCoinsNumeric.getArrayList().addLast(coin);
			coin.getImageView().setVisible(true);

			map.getValue(10).substract(1);

		}

		while (map.getValue(5).get() > 0) {

			ArrayList<Coin> arrayList = this.mapImageViews.getValue(ePlayer).getValue(5);
			Coin coin = arrayList.removeFirst();
			arrayList.addLast(coin);
			this.listCoinsNumeric.getArrayList().addLast(coin);
			coin.getImageView().setVisible(true);

			map.getValue(5).substract(1);

		}

		while (map.getValue(3).get() > 0) {

			ArrayList<Coin> arrayList = this.mapImageViews.getValue(ePlayer).getValue(3);
			Coin coin = arrayList.removeFirst();
			arrayList.addLast(coin);
			this.listCoinsNumeric.getArrayList().addLast(coin);
			coin.getImageView().setVisible(true);

			map.getValue(3).substract(1);

		}

		while (map.getValue(1).get() > 0) {

			ArrayList<Coin> arrayList = this.mapImageViews.getValue(ePlayer).getValue(1);
			Coin coin = arrayList.removeFirst();
			arrayList.addLast(coin);
			this.listCoinsNumeric.getArrayList().addLast(coin);
			coin.getImageView().setVisible(true);

			map.getValue(1).substract(1);

		}

		// relocate list

		this.listCoinsNumeric.relocateImageViews();

		// check for zero

		if (this.listCoinsNumeric.getArrayList().isEmpty())
			for (CoinBack coinBack : this.listCoinsBack)
				coinBack.getImageView().setVisible(true);

	}

	private int getDenomination(int number, int denominator) {

		int denominations = 0;

		while (number >= denominator) {

			number -= denominator;
			denominations++;

		}

		return denominations;

	}

	private void createMapNumeric() {

		this.coins.put(EPlayer.HUMAN, new Numeric(0));
		this.coins.put(EPlayer.BOT, new Numeric(0));

	}

	private void createMapImageViews() {

		this.mapImageViews.put(EPlayer.HUMAN, new HashMap<>());
		this.mapImageViews.put(EPlayer.BOT, new HashMap<>());

		this.mapImageViews.getValue(EPlayer.HUMAN).put(1, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.HUMAN).getValue(1).addLast(new CoinPlayer(1));
		this.mapImageViews.getValue(EPlayer.HUMAN).getValue(1).addLast(new CoinPlayer(1));

		this.mapImageViews.getValue(EPlayer.HUMAN).put(3, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.HUMAN).getValue(3).addLast(new CoinPlayer(3));

		this.mapImageViews.getValue(EPlayer.HUMAN).put(5, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.HUMAN).getValue(5).addLast(new CoinPlayer(5));

		this.mapImageViews.getValue(EPlayer.HUMAN).put(10, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.HUMAN).getValue(10).addLast(new CoinPlayer(10));
		this.mapImageViews.getValue(EPlayer.HUMAN).getValue(10).addLast(new CoinPlayer(10));

		this.mapImageViews.getValue(EPlayer.BOT).put(1, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.BOT).getValue(1).addLast(new CoinBot(1));
		this.mapImageViews.getValue(EPlayer.BOT).getValue(1).addLast(new CoinBot(1));

		this.mapImageViews.getValue(EPlayer.BOT).put(3, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.BOT).getValue(3).addLast(new CoinBot(3));

		this.mapImageViews.getValue(EPlayer.BOT).put(5, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.BOT).getValue(5).addLast(new CoinBot(5));

		this.mapImageViews.getValue(EPlayer.BOT).put(10, new ArrayList<>());
		this.mapImageViews.getValue(EPlayer.BOT).getValue(10).addLast(new CoinBot(10));
		this.mapImageViews.getValue(EPlayer.BOT).getValue(10).addLast(new CoinBot(10));

		this.listCoinsBack.getArrayList().addLast(new CoinBackPlayer());
		this.listCoinsBack.getArrayList().addLast(new CoinBackBot());
		this.listCoinsBack.relocateImageViews();

	}

}
