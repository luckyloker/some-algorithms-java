package algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.LongStream;

import static algorithms.SomeAlgorithms.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeAlgorithmsTest {

    private static final long[] array = LongStream.range(0, 10000).map(i -> i*Math.round(100*Math.random())).toArray();
    private static long[] sortedArray;


    @BeforeAll
    static void before() {
        sortedArray = LongStream.of(array).sorted().toArray();
    }

    @Test
    void testMergeSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        mergeSort(testArray, testArray.length);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testInsertionSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        insertionSort(testArray);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testRecursiveInsertionSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        recursiveInsertionSort(testArray, 1);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testBubbleSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        bubbleSort(testArray);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testRecursiveBubbleSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        recursiveBubbleSort(testArray, testArray.length);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testSelectionSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        selectionSort(testArray);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testRecursiveSelectionSort() {
        long[] testArray = Arrays.copyOf(array, array.length);
        recursiveSelectionSort(testArray, testArray.length);
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void testFactorial() {
        long actual = factorial(11);
        assertEquals(39916800, actual);
    }

    @Test
    void testFibonacciNumber() {
        long actual = fibonacciNumber(18);
        assertEquals(2584, actual);
    }
}
