import org.example.MyCollections;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyCollectionsTest {

    @Test
    void testBinarySearchWithNaturalOrder() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
        assertEquals(2, MyCollections.binarySearch(list, 5));
        assertEquals(0, MyCollections.binarySearch(list, 1));
        assertEquals(4, MyCollections.binarySearch(list, 9));
        assertEquals(-1, MyCollections.binarySearch(list, 0));
        assertEquals(-6, MyCollections.binarySearch(list, 10));
    }

    @Test
    void testBinarySearchWithCustomComparator() {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");
        Comparator<String> comparator = Comparator.naturalOrder();

        assertEquals(1, MyCollections.binarySearch(list, "banana", comparator));
        assertEquals(3, MyCollections.binarySearch(list, "date", comparator));
        assertEquals(-5, MyCollections.binarySearch(list, "elderberry", comparator));
    }

    @Test
    void testBinarySearchEmptyList() {
        List<Integer> emptyList = Collections.emptyList();
        assertEquals(-1, MyCollections.binarySearch(emptyList, 1));
    }

    @Test
    void testBinarySearchSingleElementList() {
        List<Integer> list = Collections.singletonList(5);
        assertEquals(0, MyCollections.binarySearch(list, 5));
        assertEquals(-1, MyCollections.binarySearch(list, 3));
    }

    @Test
    void testBinarySearchDescendingOrder() {
        List<Integer> list = Arrays.asList(9, 7, 5, 3, 1);
        Comparator<Integer> descendingComparator = Comparator.reverseOrder();

        assertEquals(2, MyCollections.binarySearch(list, 5, descendingComparator));
        assertEquals(0, MyCollections.binarySearch(list, 9, descendingComparator));
        assertEquals(4, MyCollections.binarySearch(list, 1, descendingComparator));
        assertEquals(-1, MyCollections.binarySearch(list, 10, descendingComparator));
    }
}
