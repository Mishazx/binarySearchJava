import org.example.MyArrays;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

public class MyArraysTest {

    @Test
    void testBinarySearchByte() {
        byte[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, MyArrays.binarySearch(arr, (byte) 5));
        assertEquals(-1, MyArrays.binarySearch(arr, (byte) 0));
        assertEquals(-6, MyArrays.binarySearch(arr, (byte) 10));
    }

    @Test
    void testBinarySearchChar() {
        char[] arr = {'a', 'c', 'e', 'g', 'i'};
        assertEquals(2, MyArrays.binarySearch(arr, 'e'));
        assertEquals(-1, MyArrays.binarySearch(arr, 'A'));
        assertEquals(-6, MyArrays.binarySearch(arr, 'z'));
    }

    @Test
    void testBinarySearchDouble() {
        double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};
        assertEquals(3, MyArrays.binarySearch(arr, 4.4));
        assertEquals(-1, MyArrays.binarySearch(arr, 0.0));
        assertEquals(-6, MyArrays.binarySearch(arr, 6.6));
    }

    @Test
    void testBinarySearchFloat() {
        float[] arr = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        assertEquals(3, MyArrays.binarySearch(arr, 4.4f));
        assertEquals(-1, MyArrays.binarySearch(arr, 0.0f));
        assertEquals(-6, MyArrays.binarySearch(arr, 6.6f));
    }

    @Test
    void testBinarySearchInt() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, MyArrays.binarySearch(arr, 5));
        assertEquals(-1, MyArrays.binarySearch(arr, 0));
        assertEquals(-6, MyArrays.binarySearch(arr, 10));
    }

    @Test
    void testBinarySearchLong() {
        long[] arr = {1L, 3L, 5L, 7L, 9L};
        assertEquals(2, MyArrays.binarySearch(arr, 5L));
        assertEquals(-1, MyArrays.binarySearch(arr, 0L));
        assertEquals(-6, MyArrays.binarySearch(arr, 10L));
    }

    @Test
    void testBinarySearchShort() {
        short[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, MyArrays.binarySearch(arr, (short) 5));
        assertEquals(-1, MyArrays.binarySearch(arr, (short) 0));
        assertEquals(-6, MyArrays.binarySearch(arr, (short) 10));
    }

    @Test
    void testBinarySearchObject() {
        String[] arr = {"apple", "banana", "cherry", "date", "fig"};
        Comparator<String> comparator = String::compareTo;
        assertEquals(2, MyArrays.binarySearch(arr, "cherry", comparator));
        assertEquals(-6, MyArrays.binarySearch(arr, "grape", comparator));
    }

    @Test
    void testValidateRange() {
        int[] arr = {1, 2, 3, 4, 5};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MyArrays.binarySearch(arr, 6, 2, 3));
        assertEquals("Начальная позиция(6) больше конечной(2)", exception.getMessage());

        exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> MyArrays.binarySearch(arr, -1, 3, 3));
        assertEquals("Начальная позиция не может быть отрицательной: -1", exception.getMessage());

        exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> MyArrays.binarySearch(arr, 0, 6, 3));
        assertEquals("Конечная позиция не может быть больше длины массива: 6", exception.getMessage());
    }
}