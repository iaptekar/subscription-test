package bbva;

/**
 * Hold the value of the current Volume Weighted Average Price and prints it out if required
 */
public class VWAP {

	private int totalShares;
	private double value;

	public VWAP addPrice(int numberofShares, double price) {
		totalShares += numberofShares;
		value = (numberofShares * price) / totalShares;
		return this;
	}

	public void printPrice() {
		System.out.println(String.format("%10.2f", value));
	}

}
