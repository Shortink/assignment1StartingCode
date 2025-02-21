package shapes;
/**
 * Created on February 20, 2025
 * @author Fazan Khan
 * @version 1.0
 */
public class Cone extends AbstractShapes {
    double radius;
    /**
     * @param height
     * @param radius
     */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calcVolume() {
        return (1.0/3.0) * Math.PI * radius * radius * height;
    }
}