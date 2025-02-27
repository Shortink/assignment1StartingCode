package utilities;

public class benchmark {
	long start, stop, duration;

	/**
	 * @param start
	 * @param stop
	 * @param duration
	 */
	public benchmark() {
		this.start = 0;
		this.stop = 0;
		this.duration = 0;
	}
	
	public void start() {
		this.start = System.currentTimeMillis();
	}
	
	public void stop() {
		this.stop = System.currentTimeMillis();
	}
	
	public long result() {
		return stop-start;
	}
}
