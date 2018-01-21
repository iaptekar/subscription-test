package bbva;

/**
 * A single market depth tick of a single instrument
 *
 */
public class Tick {

	enum Side {
		BID, ASK
	}

	private int volume;
	private double price;
	private Side side;
	private String symbol;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
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

	public boolean isAsk() {
		return side == Side.ASK;
	}

	public void setSide(Side side) {
		this.side = side;
	}
}
