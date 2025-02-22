package shapes;
/**
 * Created on February 21, 2025
 * @author Elvis
 * @version 1.0
 */

public class SquarePrism extends AbstractPrisms {
	
	public SquarePrism(double side, double height) {
		super(side, height);
	}
	
	@Override
	public double calcBaseArea() {
		return side * side;
	}
	
	@Override 
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
