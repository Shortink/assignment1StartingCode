/*
 * @author Navi
 */

package shapes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeFileParser {

    public static Shape[] parseShapesFromFile(String filePath) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            int numberOfShapes = Integer.parseInt(scanner.nextLine().trim());
            Shape[] shapes = new Shape[numberOfShapes];

            for (int i = 0; i < numberOfShapes; i++) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    shapes[i] = createShapeFromLine(line);
                }
            }

            return shapes;
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
            return null;
        }
    }

    private static Shape createShapeFromLine(String line) {
        String[] parts = line.split("\\s+");
        String shapeType = parts[0];
        double height = Double.parseDouble(parts[1]);
        double dimension = Double.parseDouble(parts[2]);

        switch (shapeType) {
            case "Cylinder":
                return new Cylinder(height, dimension);
            case "Cone":
                return new Cone(height, dimension);
            case "SquarePrism":
                return new SquarePrism(height, dimension);
            case "TriangularPrism":
                return new TriangularPrism(height, dimension);
            case "PentagonalPrism":
                return new PentagonalPrism(height, dimension);
            case "OctagonalPrism":
                return new OctagonalPrism(height, dimension);
            case "Pyramid":
                return new Pyramid(height, dimension);
            default:
                System.out.println("Unsupported shape type: " + shapeType);
                return null;
        }
    }
}
