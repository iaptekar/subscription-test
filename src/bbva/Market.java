package bbva;

/**
 * Markets provide ticks on instruments subscribed to
 *
 */
public interface Market {

	void subscribe(String instrument);

	Tick nextTick();
}
