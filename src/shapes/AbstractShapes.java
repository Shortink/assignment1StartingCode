package shapes;

/**
 * Created on February 19, 2025
 * @author bbteruel
 * @version 1.0
 */

public abstract class AbstractShapes implements IShapes, Comparable<AbstractShapes>{
	double height;

	/**
	 * @param height
	 */
	public AbstractShapes(double height) {
		this.height = height;
	}
	
	@Override
	public int compareTo(AbstractShapes that) {
		if ( this.height > that.height)
			return 1;
		else if ( this.height < that.height)
			return -1;
		else
			return 0;
	}
}
