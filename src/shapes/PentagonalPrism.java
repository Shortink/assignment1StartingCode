package shapes;
/**
 * Created on February 21, 2025
 * @author Elvis
 * @version 1.0
 */

public class PentagonalPrism extends AbstractPrisms {
	
	public PentagonalPrism(double side, double height) {
        super(side, height);
    }
	
	@Override
	public double calcBaseArea() {
		return (5 * (side * side) * Math.tan(Math.toRadians(54))) / 4;
	}
	
	@Override 
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
