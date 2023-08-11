package utils;

public class NumberIndicator {

	private TextIndicator textIndicator = new TextIndicator();
	private String text = "";
	private int totalValue, startingValue, currentValue;

	public NumberIndicator(String text, int totalValue, int startingValue, double x, double y) {

		this.text = text;
		this.textIndicator.relocateTopLeft(x, y);
		this.totalValue = totalValue;
		this.startingValue = startingValue;
		this.currentValue = this.startingValue;

		updateIndicator();

	}

	public NumberIndicator(String text, int totalValue, int startingValue, Vector2 coordinates) {
		this(text, totalValue, startingValue, coordinates.x, coordinates.y);
	}

	public NumberIndicator(String text, int startingValue, double x, double y) {
		this(text, -1, startingValue, x, y);
	}

	public NumberIndicator(String text, int startingValue, Vector2 coordinates) {
		this(text, startingValue, coordinates.x, coordinates.y);
	}

	public void addOne() {

		this.currentValue++;

		if (this.totalValue != -1)
			this.currentValue = Math.min(this.currentValue, this.totalValue);

		updateIndicator();

	}

	public void substractOne() {

		this.currentValue--;
		this.currentValue = Math.max(this.currentValue, 0);

		updateIndicator();

	}

	private void updateIndicator() {

		String text = this.text;
		text += ": ";
		text += this.currentValue;

		if (this.totalValue != -1) {

			text += "/";
			text += this.totalValue;

		}

		this.textIndicator.setText(text);

	}

	public void setCurrentValue(int value) {

		this.currentValue = value;
		updateIndicator();

	}

	public int getCurrentValue() {
		return this.currentValue;
	}

}
