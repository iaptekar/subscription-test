package bbva;

import java.util.HashMap;
import java.util.Map;

public class Market implements Runnable {

	private final Map<String, InstrumentListener> listeners = new HashMap<>();

	private final MarketConnection connection;

	public Market(MarketConnection connection) {
		this.connection = connection;
	}

	public void subscribe(String instrument, InstrumentListener listener) {
		listeners.put(instrument, listener);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			Tick tick = connection.nextTick();
			InstrumentListener listener = listeners.get(tick.getSymbol());
			if (listener != null) {
				listener.onTick(tick);
			}

		}
	}
}
