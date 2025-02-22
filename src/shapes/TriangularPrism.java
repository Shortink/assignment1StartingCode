package shapes;
/**
 * Created on February 21, 2025
 * @author Elvis
 * @version 1.0
 */

public class TriangularPrism extends AbstractPrisms {
	
	public TriangularPrism(double side, double height) {
        super(side, height);
    }
	
	@Override
	public double calcBaseArea() {
		return (Math.sqrt(3) / 4) * side * side;
	}
	
	@Override 
	public double calcVolume() {
		return calcBaseArea() * height;
	}
}
