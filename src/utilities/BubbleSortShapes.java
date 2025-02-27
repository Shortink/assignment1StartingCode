package utilities;

/**
 * Created on February 26, 2025
 * @author bbteruel
 * @version 1.0
 */

import java.util.Comparator;

import shapes.AbstractShapes;

public class BubbleSortShapes {
	public static void sort(AbstractShapes[] unsortedArray) {
		AbstractShapes[] sortedArray = unsortedArray; 
		for( int i = 0; i < sortedArray.length-1; i++ ) {
			for ( int j = 1; j <= sortedArray.length-1; j++ ) {
				if( sortedArray[j].compareTo(sortedArray[j-1]) == 1) {
					AbstractShapes temp = null;
					temp = sortedArray[j];
					sortedArray[j] = sortedArray[j-1];
					sortedArray[j-1] = temp;
				}
			}
		}
	}
	
	public static void sort(AbstractShapes[] unsortedArray, Comparator<AbstractShapes> sortBy) {
		AbstractShapes[] sortedArray = unsortedArray; 
		for( int i = 0; i < sortedArray.length-1; i++ ) {
			for ( int j = 1; j <= sortedArray.length-1; j++ ) {
				if( sortBy.compare(sortedArray[j], sortedArray[j-1]) == 1){
					AbstractShapes temp = null;
					temp = sortedArray[j];
					sortedArray[j] = sortedArray[j-1];
					sortedArray[j-1] = temp;
				}
			}
		}
	}
}
