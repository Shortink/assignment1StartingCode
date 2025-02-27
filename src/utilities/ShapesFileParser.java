/*
 * @author Navi
 */

package utilities;

import java.io.*;

import shapes.AbstractShapes;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.SquarePrism;
import shapes.TriangularPrism;

public class ShapesFileParser {

    public static AbstractShapes[] parseShapesFile(String filePath) throws IOException {
        
    	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // bbteruel February 26, 2025
    		// Fix buffer reader skipping 1st line of file defining number of shapes to read
    		// Read the first line -> Number of shapes
            int numShapes = Integer.parseInt(reader.readLine().trim());
            
            System.out.println("Parsing " + numShapes + " shapes...");
            // bbteruel, Fazan February 26, 2025
            // Assignment specification item 6 – use Array not ArrayList
            AbstractShapes[] shapes = new AbstractShapes[numShapes];
    		String line;
    		
    		int index = 0;
    		
            while ((line = reader.readLine()) != null && index < numShapes) {
                String[] parts = line.split(" ");

                String shapeType = parts[0];
                double height = Double.parseDouble(parts[1]);
                double dimension = Double.parseDouble(parts[2]);

                switch (shapeType.toLowerCase()) {
                    case "cylinder":
                    	shapes[index] = new Cylinder(height, dimension);
                        break;
                    case "cone":
                    	shapes[index] = new Cone(height, dimension);
                        break;
                    case "pyramid":
                    	shapes[index] = new Pyramid(height, dimension);
                        break;
                    case "octagonalprism":
                    	shapes[index] = new OctagonalPrism(height, dimension);
                        break;
                    case "pentagonalprism":
                    	shapes[index] = new PentagonalPrism(height, dimension);
                        break;
                    case "squareprism":
                    	shapes[index] = new SquarePrism(height, dimension);
                        break;
                    case "triangularprism":
                    	shapes[index] = new TriangularPrism(height, dimension);
                        break;
                    default:
                        System.err.println("Unsupported shape type: " + shapeType);
                        break;
                }
                index++;
            }
            return shapes;
            
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number from file: " + e.getMessage());
        }
    	
		return null;
    }
}
