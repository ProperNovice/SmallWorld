package utils;

public class Vector2 {

	public double x, y;

	public Vector2(double x, double y) {

		this.x = x;
		this.y = y;

	}

	public void addVector2(Vector2 vector2) {
		addX(vector2.x);
		addY(vector2.y);
	}

	public void addX(double x) {
		this.x += x;
	}

	public void addY(double y) {
		this.y += y;
	}

	public void substractVector2(Vector2 vector2) {
		substractX(vector2.x);
		substractY(vector2.y);
	}

	public void substractX(double x) {
		this.x -= x;
	}

	public void substractY(double y) {
		this.y -= y;
	}

	public void print() {

		Logger.INSTANCE.log("x -> " + this.x);
		Logger.INSTANCE.log("y -> " + this.y);
		Logger.INSTANCE.newLine();

	}

	public Vector2 clone() {
		return new Vector2(this.x, this.y);
	}

}
