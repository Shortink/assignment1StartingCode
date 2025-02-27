package utilities;

import java.util.Comparator;

import shapes.AbstractShapes;

public class QuickSortShapes {

    public static void sort(AbstractShapes[] array, int begin, int end, Comparator<AbstractShapes> comparator) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end, comparator);
            sort(array, begin, partitionIndex - 1, comparator); 
            sort(array, partitionIndex + 1, end, comparator); 
        }
    }

    private static int partition(AbstractShapes[] array, int begin, int end, Comparator<AbstractShapes> comparator) {
    	AbstractShapes pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
        	// bbteruel February 26, 2025
            // Descending order
            if (comparator.compare(pivot, array[j]) <= 0) {
                i++;

                AbstractShapes swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        AbstractShapes swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;
        return i + 1;
    }
    
    // bbteruel February 26, 2025
    // Using comparable
    
    public static void sort(AbstractShapes[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            sort(array, begin, partitionIndex - 1); 
            sort(array, partitionIndex + 1, end); 
        }
    }

    private static int partition(AbstractShapes[] array, int begin, int end) {
    	AbstractShapes pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if ((pivot.compareTo(array[j])) <= 0) {
                i++;

                AbstractShapes swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        AbstractShapes swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;
        return i + 1;
    }
}
