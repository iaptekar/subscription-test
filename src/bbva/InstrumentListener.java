package bbva;

import java.util.concurrent.atomic.AtomicInteger;

import bbva.Tick.Side;

/**
 * Listens for market depth tick for a specific instrument and print out VWAP
 */
public class InstrumentListener {

	private final AtomicInteger totalBidVolume = new AtomicInteger();
	private final AtomicInteger totalAskVolume = new AtomicInteger();

	private final String symbol;

	public InstrumentListener(String symbol) {
		this.symbol = symbol;
	}

	public void onTick(Tick tick) {
		int totalVolume = tick.getSide() == Side.ASK ? totalAskVolume.addAndGet(tick.getVolume())
				: totalBidVolume.addAndGet(tick.getVolume());
		System.out.println(String.format("%s %s VWAP = %10.2f", symbol, tick.getSide().name(),
				(tick.getVolume() * tick.getPrice()) / totalVolume));
	}

}
