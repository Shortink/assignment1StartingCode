package utilities;

import java.util.Comparator;

import shapes.AbstractShapes;


// This algorithm works in 2 main phases 1. Transform the input array into a max heap structure using heapify
// 2. Repeatedly extract the maximum element from the heap and swap it to the end of the array
// 3. Repeat untill array is sorted
public class HeapSortShapes {
	
	public static void sort (AbstractShapes[] array, Comparator<AbstractShapes> comparator) {
		int n = array.length;
		
		//Build Maximum Heap
		for (int i = n/2 - 1; i >= 0; i--) {
			heapify(array, n, i, comparator);
		}
		
		for (int i = n - 1; i > 0; i--) {
            // Move the current root (maximum element) to the end
			AbstractShapes temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Heapify the reduced heap
            heapify(array, i, 0, comparator);
        }
		
	}
	
	private static void heapify(AbstractShapes[] array, int n, int i, Comparator<AbstractShapes> comparator) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//if left child is larger than the root
    	// bbteruel February 26, 2025
        // Descending order
		if(left < n && comparator.compare(array[left], array[largest]) < 0) {
			largest = left;
		}
		
		//if right child is larger than the root
    	// bbteruel February 26, 2025
        // Descending order
		if (right < n && comparator.compare(array[right], array[largest]) < 0) {
            largest = right;
        }
		
    	// bbteruel February 26, 2025
        // recursive call only when swapped
		if (largest != i) {
		    AbstractShapes temp = array[i];
		    array[i] = array[largest];
		    array[largest] = temp;

		    heapify(array, n, largest, comparator);
		}
	}
	
    // bbteruel February 26, 2025
    // Using comparable
	
	public static void sort (AbstractShapes[] array) {
		int n = array.length;
		
		//Build Maximum Heap
		for (int i = n/2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}
		
		for (int i = n - 1; i > 0; i--) {
            // Move the current root (maximum element) to the end
			AbstractShapes temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Heapify the reduced heap
            heapify(array, i, 0);
        }
		
	}
	
	private static void heapify(AbstractShapes[] array, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//if left child is larger than the root
    	// bbteruel February 26, 2025
        // Descending order
		if(left < n && (array[left].compareTo(array[largest]) ) < 0) {
			largest = left;
		}
		
		//if right child is larger than the root
    	// bbteruel February 26, 2025
        // Descending order
		if (right < n && array[right].compareTo(array[largest]) < 0) {
            largest = right;
        }
		
    	// bbteruel February 26, 2025
        // recursive call only when swapped
		if (largest != i) {
		    AbstractShapes temp = array[i];
		    array[i] = array[largest];
		    array[largest] = temp;

		    heapify(array, n, largest);
		}
	}

}
