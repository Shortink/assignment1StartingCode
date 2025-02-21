package shapes;
/**
 * Created on February 20, 2025
 * @author Fazan Khan
 * @version 1.0
 */
public class Pyramid extends AbstractShapes {
    double side;
    /**
     * @param height
     * @param side
     */
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }
    
    @Override
    public double calcBaseArea() {
        return side * side;
    }
    
    @Override
    public double calcVolume() {
        return (1.0/3.0) * side * side * height;
    }
}