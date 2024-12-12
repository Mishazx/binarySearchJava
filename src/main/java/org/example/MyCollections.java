package org.example;

import java.util.Comparator;
import java.util.List;

public class MyCollections {

    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T key) {
        if (list == null) {
            throw new NullPointerException("The list cannot be null");
        }
        return binarySearch(list, key, Comparator.naturalOrder());
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> comparator) {
        if (list == null) {
            throw new NullPointerException("The list cannot be null");
        }
        if (comparator == null) {
            throw new NullPointerException("The comparator cannot be null");
        }


        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            T currentValue = list.get(mid);
            int comparisonResult = comparator.compare(currentValue, key);

            if (comparisonResult < 0)
                low = mid + 1;
            else if (comparisonResult > 0)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }
}
