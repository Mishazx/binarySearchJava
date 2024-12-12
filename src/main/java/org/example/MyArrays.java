package org.example;

import java.util.Comparator;

public class MyArrays {

    public static int binarySearch(byte[] arr, byte key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(byte[] arr, int low, int high, byte key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            byte midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int binarySearch(char[] arr, char key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(char[] arr, int low, int high, char key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            char midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int binarySearch(double[] arr, double key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(double[] arr, int low, int high, double key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        if (Double.isNaN(key)) {
            for (int i = low; i < high; i++) {
                if (Double.isNaN(arr[i])) {
                    return i;
                }
            }
            return -(low + 1);
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            double midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int binarySearch(float[] arr, float key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(float[] arr, int low, int high, float key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            float midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int binarySearch(int[] arr, int key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int binarySearch(long[] arr, long key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(long[] arr, int low, int high, long key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static int binarySearch(short[] arr, short key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        return binarySearch(arr, 0, arr.length, key);
    }

    public static int binarySearch(short[] arr, int low, int high, short key) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            short midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static <T> int binarySearch(T[] array, T key, Comparator<? super T> comparator) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // Avoid overflow for large indices
            int cmp = comparator.compare(key, array[mid]);

            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid; // Key found
            }
        }
        return -(low + 1); // Key not found
    }

    public static <T> int binarySearch(T[] arr, int low, int high, T key, Comparator<? super T> cmp) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be empty");
        }
        validateRange(arr.length, low, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            int cmpResult = cmp.compare(arr[mid], key);

            if (cmpResult < 0)
                low = mid + 1;
            else if (cmpResult > 0)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    private static void validateRange(int length, int low, int high) {
        if (low > high) {
            throw new IllegalArgumentException(
                    "Start position (" + low + ") is greater than end position (" + high + ")");
        }
        if (low < 0) {
            throw new ArrayIndexOutOfBoundsException("Start position cannot be negative: " + low);
        }
        if (high > length) {
            throw new ArrayIndexOutOfBoundsException("End position cannot be greater than array length: " + high);
        }
    }

}
