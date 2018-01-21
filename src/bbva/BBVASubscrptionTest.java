package bbva;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BBVASubscrptionTest {

	static Market[] markets = {};
	static String[] instruments = { "A", "B", "C", "IBM" };

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(markets.length);
		for (Market market : markets) {
			for (String instrument : instruments) {
				market.subscribe(instrument, new InstrumentListener());
			}
			pool.execute(market);
		}
	}

}
