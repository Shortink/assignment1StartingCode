package shapes;

/**
 * Created on February 19, 2025
 * @author bbteruel
 * @version 1.0
 */

public abstract class AbstractPrisms extends AbstractShapes{
	double side;

	public double getSide() {
		return side;
	}

	/**
	 * @param height
	 * @param side
	 */
	public AbstractPrisms(double height, double side) {
		super(height);
		this.side = side;
	}
}
