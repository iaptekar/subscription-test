package bbva;

import java.util.Map;

public class MarketListener implements Runnable {

	private final Map<String, InstrumentListener> listeners;

	private final Market market;

	public MarketListener(Market market, Map<String, InstrumentListener> listeners) {
		this.market = market;
		this.listeners = listeners;
		listeners.keySet().forEach(i -> market.subscribe(i));
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			Tick tick = market.nextTick();
			InstrumentListener listener = listeners.get(tick.getSymbol());
			if (listener != null) {
				listener.onTick(tick);
			}

		}
	}
}
