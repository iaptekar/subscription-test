package bbva;

/**
 * Listens for market depth tick for a specific instrument
 *
 */
public class InstrumentListener {

	private final VWAP vwapBidPrice = new VWAP();
	private final VWAP vwapSellPrice = new VWAP();

	public void onTick(Tick tick) {
		if (tick.isSell()) {
			vwapSellPrice.addPrice(tick.getNumberOfShares(), tick.getPrice()).printPrice();
		} else {
			vwapBidPrice.addPrice(tick.getNumberOfShares(), tick.getPrice()).printPrice();
		}
	}

}
