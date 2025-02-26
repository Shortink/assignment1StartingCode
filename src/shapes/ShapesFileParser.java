/*
 * @author Navi
 */

package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapesFileParser {

    public static List<IShapes> parseShapesFile(String filePath) throws IOException {
        List<IShapes> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 3) {
                    System.err.println("Skipping invalid line: " + line);
                    continue;
                }

                String shapeType = parts[0];
                double height = Double.parseDouble(parts[1]);
                double dimension = Double.parseDouble(parts[2]);

                switch (shapeType.toLowerCase()) {
                    case "cylinder":
                        shapes.add(new Cylinder(height, dimension));
                        break;
                    case "pyramid":
                        shapes.add(new Pyramid(height, dimension));
                        break;
                    case "octagonalprism":
                        shapes.add(new OctagonalPrism(height, dimension));
                        break;
                    case "pentagonalprism":
                        shapes.add(new PentagonalPrism(height, dimension));
                        break;
                    case "squareprism":
                        shapes.add(new SquarePrism(height, dimension));
                        break;
                    case "triangularprism":
                        shapes.add(new TriangularPrism(height, dimension));
                        break;
                    default:
                        System.err.println("Unsupported shape type: " + shapeType);
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number from file: " + e.getMessage());
        }
        return shapes;
    }
}
