package appDomain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;

import exception.InvalidArgumentException;
import shapes.AbstractShapes;
import shapes.CompareBaseArea;
import shapes.CompareVolume;
import utilities.*;

public class AppDriver
{

	public static void main(String[] args) {
	    // Handle Program Arguments
	    // 2025FEB20 BBTERUEL
	    String argsFileName = null;
	    String argsType = null;
	    String argsSort = null;

	    if (args.length == 0) {
	        System.err.println("No arguments provided.");
	        return;
	    }

	    System.out.println("Arguments List:");

	    try {
	        for (int i = 0; i < args.length; i++) {

	            System.out.println("Argument " + i + ": " + args[i]);

	            // file name argument
	            if ("-f".equalsIgnoreCase(args[i].substring(0, 2))) {
	                argsFileName = args[i].substring(2);
	                System.out.println("\tFile Name: " + argsFileName);
	                
	                File file = new File(argsFileName);
	                if (!file.exists()) {
	                    throw new FileNotFoundException("File Not Found: " + argsFileName);
	                }
	            }

	            // type argument
	            if ("-t".equalsIgnoreCase(args[i].substring(0, 2))) {
	                argsType = args[i].substring(2).toLowerCase();
	                if (!argsType.equals("v") && !argsType.equals("h") && !argsType.equals("a")) {
	                    throw new InvalidArgumentException("Invalid Type Argument: " + argsType +
	                            "\nValid Arguments: v (volume), h (height), a (base area)");
	                }
	                System.out.println("\tSort by: " + argsType);
	            }

	            // sort argument
	            if ("-s".equalsIgnoreCase(args[i].substring(0, 2))) {
	                argsSort = args[i].substring(2).toLowerCase();
	                if (!argsSort.matches("[bsimqz]")) {
	                    throw new InvalidArgumentException("Invalid Sort Argument: " + argsSort +
	                            "\nValid Arguments: b (bubble), s (selection), i (insertion), m (merge), q (quick), z (heap sort)");
	                }
	                System.out.println("\tSort using: " + argsSort);
	            }
	        }

	        if (argsFileName == null || argsType == null || argsSort == null) {
	            throw new InvalidArgumentException("Missing Required Arguments!");
	        }

	    } catch (FileNotFoundException e) {
	        System.err.println("\nERROR: " + e.getMessage());
	        System.exit(1);
	    } catch (InvalidArgumentException e) {
	        System.exit(1);
	    } catch (StringIndexOutOfBoundsException e) {
	        System.out.println("\nERROR: Invalid Argument Format!");
	        System.exit(1);
	    }
		System.out.println();
		
		// bbteruel February 26, 2025
        // Parse file and print output
		
		AbstractShapes[] shapesArray = null;
		
		try {
			shapesArray = ShapesFileParser.parseShapesFile(argsFileName);
			System.out.println("Shapes parsed successfully!");
			
//            for (int i = 0; i < shapesArray.length; i++) {
//                if (shapesArray[i] != null) { // Check if shape is not null
//                    System.out.println("Shape " + (i+1) + ": " + shapesArray[i].getClass().getName());
//                }
//            }
            System.out.println();
		}catch (Exception e) {
			System.err.println("Error parsing file.");
			// TODO file not found
		}
		
		// bbteruel February 26, 2025
        // Sort by arguments
		Benchmark sortingBenchmark = new Benchmark(argsSort);
		
		switch (argsType.toLowerCase()) {
		// by height
		case "h":
			sortingBenchmark.start();
			switch (argsSort.toLowerCase()) {
			case "b":
				utilities.BubbleSortShapes.sort(shapesArray);
				break;
			case "i":
				utilities.InsertionSortShapes.sort(shapesArray);
				break;
			case "s":
				utilities.SelectionSortShapes.sort(shapesArray);
				break;
			case "m":
				utilities.MergeSortShapes.sort(shapesArray);
				break;
			case "q":
				utilities.QuickSortShapes.sort(shapesArray, 0, shapesArray.length-1);
				break;
			case "z":
				utilities.HeapSortShapes.sort(shapesArray);
				break;

			default:
				break;
			}
			sortingBenchmark.stop();
			
			for (int i = 0; i < shapesArray.length; i++) {
			    if (shapesArray[i] != null) {
			    	if(i==0) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
				    			"First element: ",
				                shapesArray[i].getClass().getName(),
				                "Height: ",
				                shapesArray[i].getHeight()));
			    	}
			    	
			    	if((i+1)%1000 == 0 && i!=shapesArray.length-1) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
			    				(i+1) + "-th element: ",
				                shapesArray[i].getClass().getName(),
				                "Height: ",
				                shapesArray[i].getHeight()));
			    	}
			    	
			    	if(i==shapesArray.length-1) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
				    			"Last element: ",
				                shapesArray[i].getClass().getName(),
				                "Height: ",
				                shapesArray[i].getHeight()));
			    	}
			    }
			}
			break;
			
		// by volume
		case "v":
			CompareVolume volume = new CompareVolume();
			sortingBenchmark.start();
			sortMethod(shapesArray, volume, argsSort);
			sortingBenchmark.stop();
			
			for (int i = 0; i < shapesArray.length; i++) {
			    if (shapesArray[i] != null) {
			    	if(i==0) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
				    			"First element: ",
				                shapesArray[i].getClass().getName(),
				                "Volume: ",
				                shapesArray[i].calcVolume()));
			    	}
			    	
			    	if((i+1)%1000 == 0 && i!=shapesArray.length-1) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
			    				(i+1) + "-th element: ",
				                shapesArray[i].getClass().getName(),
				                "Volume: ",
				                shapesArray[i].calcVolume()));
			    	}
			    	
			    	if(i==shapesArray.length-1) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
				    			"Last element: ",
				                shapesArray[i].getClass().getName(),
				                "Volume: ",
				                shapesArray[i].calcVolume()));
			    	}
			    }
			}
			
			break;
			
		// by area
		case "a":
			CompareBaseArea area = new CompareBaseArea();
			sortingBenchmark.start();
			sortMethod(shapesArray, area, argsSort);
			sortingBenchmark.stop();
			
			for (int i = 0; i < shapesArray.length; i++) {
			    if (shapesArray[i] != null) {
			    	if(i==0) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
				    			"First element: ",
				                shapesArray[i].getClass().getName(),
				                "Area: ",
				                shapesArray[i].calcBaseArea()));
			    	}
			    	
			    	if((i+1)%1000 == 0 && i!=shapesArray.length-1) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
			    				(i+1) + "-th element: ",
				                shapesArray[i].getClass().getName(),
				                "Area: ",
				                shapesArray[i].calcBaseArea()));
			    	}
			    	
			    	if(i==shapesArray.length-1) {
			    		System.out.println(String.format("\t%20s %30s %10s %20.3f",
				    			"Last element: ",
				                shapesArray[i].getClass().getName(),
				                "Area: ",
				                shapesArray[i].calcBaseArea()));
			    	}
			    }
			}
			
			break;
			
		default:
			break;
		}
		System.out.println(sortingBenchmark.toString()); 
	}
	
	public static void sortMethod(AbstractShapes[] array, Comparator<AbstractShapes> sortBy, String sortMethod) {
		switch (sortMethod.toLowerCase()) {
		case "b":
			utilities.BubbleSortShapes.sort(array, sortBy);
			break;
		case "i":
			utilities.InsertionSortShapes.sort(array, sortBy);
			break;
		case "s":
			utilities.SelectionSortShapes.sort(array, sortBy);
			break;
		case "m":
			utilities.MergeSortShapes.sort(array, sortBy);
			break;
		case "q":
			utilities.QuickSortShapes.sort(array, 0, array.length-1, sortBy);
			break;
		case "z":
			utilities.HeapSortShapes.sort(array, sortBy);
			break;

		default:
			break;
		}
		
	}
}
