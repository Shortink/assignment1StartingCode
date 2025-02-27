package utilities;

/**
 * Created on February 26, 2025
 * @author bbteruel
 * @version 1.0
 */

public class Benchmark {
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	long start, stop, duration;

	/**
	 * @param name
	 * @param start
	 * @param stop
	 * @param duration
	 */
	
	public Benchmark(String sortName) {
		switch (sortName.toLowerCase()) {
		case "b":
			this.name = "Bubble Sort";
			break;
		case "i":
			this.name = "Insertion Sort";
			break;
		case "s":
			this.name = "Selection Sort";
			break;
		case "m":
			this.name = "Merge Sort";
			break;
		case "q":
			this.name = "Quick Sort";
			break;
		case "z":
			this.name = "Custom Sort";
			break;

		default:
			break;
		}
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " runtime was: " + result() + " milliseconds";
	}
}
