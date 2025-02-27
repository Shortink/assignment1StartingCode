package utilities;

import java.util.Comparator;

import shapes.AbstractShapes;

/**
 * Created on February 26, 2025
 * @author bbteruel
 * @version 1.0
 */

public class InsertionSortShapes {
	public static void sort(AbstractShapes[] unsortedArray) {
		AbstractShapes[] sortedArray = unsortedArray;
		for( int i = 0; i < unsortedArray.length; i++ ) {
			AbstractShapes element = unsortedArray[i];
			int j = i;
			
			while(j > 0 && element.compareTo(sortedArray[j-1]) == 1) {
				sortedArray[j] = sortedArray[j-1];
				j--;
			}
			sortedArray[j] = element;
		}
	}
	
	public static void sort(AbstractShapes[] unsortedArray, Comparator<AbstractShapes> sortBy) {
		AbstractShapes[] sortedArray = unsortedArray;
		for( int i = 0; i < unsortedArray.length; i++ ) {
			AbstractShapes element = unsortedArray[i];
			int j = i;
			
			while(j > 0 && sortBy.compare(element, sortedArray[j-1]) == 1) {
				sortedArray[j] = sortedArray[j-1];
				j--;
			}
			sortedArray[j] = element;
		}
	}
}
