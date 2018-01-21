package bbva;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InstrumentSubscriptionService {

	private final Map<String, InstrumentListener> listeners = new HashMap<>();

	private final Collection<Market> markets;

	private ExecutorService pool;

	public InstrumentSubscriptionService(Collection<Market> markets, Collection<String> instruments) {
		this.markets = markets;
		instruments.forEach(instrument -> listeners.put(instrument, new InstrumentListener()));
	}

	public void start() {
		pool = Executors.newFixedThreadPool(markets.size());
		markets.forEach(market -> pool.execute(new MarketListener(market, listeners)));
	}

	public void stop() {
		if (pool == null) {
			return;
		}
		pool.shutdownNow();
		try {
			pool.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// ignore
		}
	}

}
