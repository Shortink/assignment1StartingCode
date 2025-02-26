package shapes;

import java.util.Comparator;

public class QuickSortShapes {

    public static void sort(IShapes[] array, int begin, int end, Comparator<IShapes> comparator) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end, comparator);
            sort(array, begin, partitionIndex - 1, comparator); 
            sort(array, partitionIndex + 1, end, comparator); 
        }
    }

    private static int partition(IShapes[] array, int begin, int end, Comparator<IShapes> comparator) {
        IShapes pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;

                IShapes swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        IShapes swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;
        return i + 1;
    }
}
