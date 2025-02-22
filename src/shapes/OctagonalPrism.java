package shapes;
/**
 * Created on February 21, 2025
 * @author Elvis
 * @version 1.0
 */

public class OctagonalPrism extends AbstractPrisms {
	
	public OctagonalPrism(double side, double height) {
        super(side, height);
    }
	
	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * (side * side);
	}
	
	@Override 
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
