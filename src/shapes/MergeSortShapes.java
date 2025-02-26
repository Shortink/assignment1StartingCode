package shapes;

import java.util.Comparator;

public class MergeSortShapes {

    public static void sort(IShapes[] array, Comparator<IShapes> comparator) {
        if (array.length < 2) {
            return; // Base case: a single element array is already sorted
        }
        int mid = array.length / 2;
        IShapes[] left = new IShapes[mid];
        IShapes[] right = new IShapes[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        sort(left, comparator); 
        sort(right, comparator); 

        merge(array, left, right, comparator); 
    }

    private static void merge(IShapes[] result, IShapes[] left, IShapes[] right, Comparator<IShapes> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
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
