package utilities;

import java.util.Comparator;

import shapes.AbstractShapes;



public class MergeSortShapes {

    public static void sort(AbstractShapes[] array, Comparator<AbstractShapes> comparator) {
        if (array.length < 2) {
            return; // Base case: a single element array is already sorted
        }
        int mid = array.length / 2;
        AbstractShapes[] left = new AbstractShapes[mid];
        AbstractShapes[] right = new AbstractShapes[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        sort(left, comparator); 
        sort(right, comparator); 

        merge(array, left, right, comparator); 
    }

    private static void merge(AbstractShapes[] result, AbstractShapes[] left, AbstractShapes[] right, Comparator<AbstractShapes> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
        	// bbteruel February 26, 2025
            // Descending order
            if (comparator.compare(right[j], left[i]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
    
    // bbteruel February 26, 2025
    // Using comparable
    
    public static void sort(AbstractShapes[] array) {
        if (array.length < 2) {
            return; // Base case: a single element array is already sorted
        }
        int mid = array.length / 2;
        AbstractShapes[] left = new AbstractShapes[mid];
        AbstractShapes[] right = new AbstractShapes[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        sort(left); 
        sort(right); 

        merge(array, left, right); 
    }

    private static void merge(AbstractShapes[] result, AbstractShapes[] left, AbstractShapes[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if ((right[j].compareTo(left[i])) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
