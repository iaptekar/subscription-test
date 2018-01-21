package bbva;

/**
 * A single market depth tick of a single instrument
 *
 */
public class Tick {

	enum Direction {
		BUY, SELL
	}

	private int numberOfShares;
	private double price;
	private Direction direction;
	private String symbol;

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public boolean isSell() {
		return direction == Direction.SELL;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
