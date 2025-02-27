package utilities;

import java.util.Comparator;

import shapes.AbstractShapes;

/**
 * Created on February 26, 2025
 * @author bbteruel
 * @version 1.0
 */

public class SelectionSortShapes {
	public static void sort(AbstractShapes[] unsortedArray) {
		AbstractShapes[] sortedArray = unsortedArray;
		for( int i = 0; i < sortedArray.length-1; i++ ) {
			int minimum = i;
			for ( int j = i+1; j <= sortedArray.length-1; j++ ) {
				if( sortedArray[j].compareTo(sortedArray[minimum]) == 1 ) {
					minimum = j;
				}
			}
			
			if ( minimum != i ) {
				AbstractShapes temp = null;
				temp = sortedArray[minimum];
				sortedArray[minimum] = sortedArray[i];
				sortedArray[i] = temp;
			}
		}
	}
	
	public static void sort(AbstractShapes[] unsortedArray, Comparator<AbstractShapes> sortBy) {
		AbstractShapes[] sortedArray = unsortedArray;
		for( int i = 0; i < sortedArray.length-1; i++ ) {
			int minimum = i;
			for ( int j = i+1; j <= sortedArray.length-1; j++ ) {
				if( sortBy.compare(sortedArray[j], sortedArray[minimum]) == 1) {
					minimum = j;
				}
			}
			
			if ( minimum != i ) {
				AbstractShapes temp = null;
				temp = sortedArray[minimum];
				sortedArray[minimum] = sortedArray[i];
				sortedArray[i] = temp;
			}
		}
	}
}
