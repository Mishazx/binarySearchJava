package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int passedTests = 0;
    private static int failedTests = 0;

    public static void main(String[] args) {
        MyArraysTesting();
        System.out.println("----------------------------");
        MyCollectionsTesting();
        resultTest();
    }

    private static void MyArraysTesting() {
        // Тесты для byte
        byte[] byteArray = {1, 3, 5, 7, 9};
        test("byteArray test 1", MyArrays.binarySearch(byteArray, (byte) 5), 2);
        test("byteArray test 2", MyArrays.binarySearch(byteArray, (byte) 2), -2);

        // Тесты для char
        char[] charArray = {'a', 'c', 'e', 'g'};
        test("charArray test 1", MyArrays.binarySearch(charArray, 'e'), 2);
        test("charArray test 2", MyArrays.binarySearch(charArray, 'b'), -2);

        // Тесты для double
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        test("doubleArray test 1", MyArrays.binarySearch(doubleArray, 3.3), 2);
        test("doubleArray test 2", MyArrays.binarySearch(doubleArray, 5.5), -5);
        test("doubleArray test 3", MyArrays.binarySearch(doubleArray, Double.NaN), -1);

        // Тесты для float
        float[] floatArray = {0.1f, 1.1f, 2.2f, 3.3f};
        test("floatArray test 1", MyArrays.binarySearch(floatArray, 1.1f), 1);
        test("floatArray test 2", MyArrays.binarySearch(floatArray, 4.4f), -5);

        // Тесты для int
        int[] intArray = {10, 20, 30, 40, 50};
        test("intArray test 1", MyArrays.binarySearch(intArray, 30), 2);
        test("intArray test 2", MyArrays.binarySearch(intArray, 25), -3);

        // Тесты для long
        long[] longArray = {100L, 200L, 300L};
        test("longArray test 1", MyArrays.binarySearch(longArray, 200L), 1);
        test("longArray test 2", MyArrays.binarySearch(longArray, 400L), -4);

        // Тесты для short
        short[] shortArray = {1, 3, 5, 7};
        test("shortArray test 1", MyArrays.binarySearch(shortArray, (short) 5), 2);
        test("shortArray test 2", MyArrays.binarySearch(shortArray, (short) 6), -4);

        // Тесты для generic (с использованием Comparator)
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        Comparator<String> stringComparator = String::compareTo;
        test("stringArray test 1", MyArrays.binarySearch(stringArray, "cherry", stringComparator), 2);
        test("stringArray test 2", MyArrays.binarySearch(stringArray, "fig", stringComparator), -5);

        // Тесты с диапазонами
        test("range test 1", MyArrays.binarySearch(intArray, 1, 3, 20), 1);
        test("range test 2", MyArrays.binarySearch(intArray, 1, 3, 50), -4);

        // Обработка ошибок
        try {
            MyArrays.binarySearch((byte[]) null, (byte) 5);
        } catch (NullPointerException e) {
            System.out.println("\u001B[33mNullPointerException: " + e.getMessage() + "\u001B[0m");
        }

        try {
            MyArrays.binarySearch(byteArray, -1, 10, (byte) 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[33mArrayIndexOutOfBoundsException: " + e.getMessage() + "\u001B[0m");
        }

        try {
            MyArrays.binarySearch(byteArray, 3, 2, (byte) 3);
        } catch (IllegalArgumentException e) {
            System.out.println("\u001B[33mIllegalArgumentException: " + e.getMessage() + "\u001B[0m");
        }
    }

    private static void MyCollectionsTesting() {
        // Тесты для Integer
        List<Integer> integerList = Arrays.asList(10, 20, 30, 40, 50);
        test("integerList test 1", MyCollections.binarySearch(integerList, 30), 2);
        test("integerList test 2", MyCollections.binarySearch(integerList, 25), -3);

        // Тесты для String
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date");
        test("stringList test 1", MyCollections.binarySearch(stringList, "cherry"), 2);
        test("stringList test 2", MyCollections.binarySearch(stringList, "fig"), -5);

        // Тесты с пользовательским компаратором
        Comparator<String> reverseStringComparator = (s1, s2) -> s2.compareTo(s1); // Сортировка по убыванию
        test("reverseStringList test 1", MyCollections.binarySearch(stringList, "cherry", reverseStringComparator), 2);
        test("reverseStringList test 2", MyCollections.binarySearch(stringList, "fig", reverseStringComparator), -1);

        // Тесты с null значениями
        try {
            MyCollections.binarySearch((List<String>) null, "apple");
        } catch (NullPointerException e) {
            System.out.println("\u001B[33mNullPointerException (null list): " + e.getMessage() + "\u001B[0m");
        }

        try {
            MyCollections.binarySearch(stringList, "apple", null);
        } catch (NullPointerException e) {
            System.out.println("\u001B[33mNullPointerException (null comparator): " + e.getMessage() + "\u001B[0m");
        }
    }

    private static void test(String testName, int actual, int expected) {
        if (actual == expected) {
            passedTests++;
            System.out.println("\u001B[32m" + testName + " passed. Result: " + actual + "\u001B[0m");
        } else {
            failedTests++;
            System.out.println("\u001B[31m" + testName + " failed. Expected: " + expected + ", but got: " + actual + "\u001B[0m");
        }
    }

    private static void resultTest() {
        // Итоговые результаты
        System.out.println("\n\u001B[34mResult testing:\u001B[0m");
        System.out.println("\u001B[32mPassed tests: " + passedTests + "\u001B[0m");
        System.out.println("\u001B[31mFailed tests: " + failedTests + "\u001B[0m");
    }
}
