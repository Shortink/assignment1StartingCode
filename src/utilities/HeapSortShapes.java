package utilities;

import java.util.Comparator;

import shapes.IShapes;


// This algorithm works in 2 main phases 1. Transform the input array into a max heap structure using heapify
// 2. Repeatedly extract the maximum element from the heap and swap it to the end of the array
// 3. Repeat untill array is sorted
public class HeapSortShapes {
	
	public static void sort (IShapes[] array, Comparator<IShapes> comparator) {
		int n = array.length;
		
		//Build Maximum Heap
		for (int i = n/2 - 1; i >= 0; i--) {
			heapify(array, n, i, comparator);
		}
		
		for (int i = n - 1; i > 0; i--) {
            // Move the current root (maximum element) to the end
            IShapes temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Heapify the reduced heap
            heapify(array, i, 0, comparator);
        }
		
	}
	
	private static void heapify(IShapes[] array, int n, int i, Comparator<IShapes> comparator) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//if left child is larger than the root
		if(left < n && comparator.compare(array[left], array[largest]) > 0) {
			largest = left;
		}
		
		//if right child is larger than the root
		if (right < n && comparator.compare(array[right], array[largest]) > 0) {
            largest = right;
        }
		
		// If largest is not root, swap and continue heapifying
		if (largest != i) {
			IShapes temp = array[i];
			array[i] = array[largest];
            array[largest] = temp;
		}
		
		heapify(array, n, largest, comparator); //recursively heapify
	}

}
