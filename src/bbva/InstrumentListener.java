package bbva;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Listens for market depth tick for a specific instrument
 *
 */
public class InstrumentListener {

	private final AtomicInteger totalBidVolume = new AtomicInteger();
	private final AtomicInteger totalAskVolume = new AtomicInteger();

	public void onTick(Tick tick) {
		int totalVolume = tick.isAsk() ? totalAskVolume.addAndGet(tick.getVolume())
				: totalBidVolume.addAndGet(tick.getVolume());
		System.out.println(String.format("%10.2f", (tick.getVolume() * tick.getPrice()) / totalVolume));
	}

}
