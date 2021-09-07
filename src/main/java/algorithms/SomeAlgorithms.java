package algorithms;


public class SomeAlgorithms {

    public static final String STRING_FORMAT = "Sort type: %s. Inner loops calls: %s. TimeInSeconds: %s";
    // Comparing Merge and Insertion sort:
    // Time complexity
    //          - merge: T(nlog2n) - for the worst, average and best cases
    //          - insertion: T(n^2) - for the worst and average cases, T(n) - best case when array is  or almost sorted
    // Conclusion: time complexity is much better in merge sorting algorithms, and insertion sorting algorithms is quicker only if array is already sorted(or almost sorted).
    // Space complexity
    //          - merge: O(n) - additional space is needed
    //          - insertion: O(1) - no additional space is needed
    // Conclusion: insertion sort algorithms can be used if memory consumption is crucial
    // Summary: mergeSort is looking like the best option for nearly every case. Exception only if array is already sorted(or almost sorted and we need to replace only couple of elements)
    // or memory consumption is limited.

    static void mergeSort(long[] array, int length) {

        if (length < 2) {
            return;
        }
        int middle = length/2;
        long[] leftArray = new long[middle];
        long[] rightArray = new long[length - middle];

        System.arraycopy(array, 0, leftArray, 0, middle);
        System.arraycopy(array, middle, rightArray, 0, length - middle);

        mergeSort(leftArray, leftArray.length);
        mergeSort(rightArray, rightArray.length);

        merge(array, leftArray, rightArray);
    }

    private static void merge(long[] array, long[] leftArray, long[] rightArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(j < leftArray.length && k < rightArray.length) {
            if (leftArray[j] <= rightArray[k]) {
                array[i++] = leftArray[j++];
            } else {
                array[i++] = rightArray[k++];
            }
        }
        while (j < leftArray.length) {
            array[i++] = leftArray[j++];
        }
        while (k < rightArray.length) {
            array[i++] = rightArray[k++];
        }
    }


    static void insertionSort(long[] array) {
        long startTime = System.currentTimeMillis();

        int innerCounter = 0;
        for (int i = 1; i < array.length; i++) {
            long temp = array[i];
            int j = i-1;
            while(j >= 0 && array[j+1] < array[j] ) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
                innerCounter++;
            }
        }

        float elapsedTimeInSeconds = (System.currentTimeMillis() - startTime)/1000F;
        System.out.printf((STRING_FORMAT) + "%n", "insertionSort", innerCounter, elapsedTimeInSeconds);
    }

    static void bubbleSort(long[] array) {
        long startTime = System.currentTimeMillis();

        int innerCounter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                innerCounter++;
                if (array[j] > array[j+1]) {
                    long temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        float elapsedTimeInSeconds = (System.currentTimeMillis() - startTime)/1000F;
        System.out.printf((STRING_FORMAT) + "%n", "bubbleSort", innerCounter, elapsedTimeInSeconds);
    }

    static void recursiveInsertionSort(long[] array, int size) {
        if (size == array.length) {
            return;
        }   else {
            for (int i = size; i > 0; i--) {
                if (array[i] < array[i -1]) {
                    long temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
           recursiveInsertionSort(array, size+1);
        }

    }

    static void selectionSort(long[] array) {
        long startTime = System.currentTimeMillis();

        int innerCounter = 0;
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j=i+1; j < array.length; j++) {
                innerCounter++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = array[minIndex];
            array[minIndex] =  array[i];
            array[i] = temp;
        }

        float elapsedTimeInSeconds = (System.currentTimeMillis() - startTime)/1000F;
        System.out.printf((STRING_FORMAT) + "%n", "selectionSort", innerCounter, elapsedTimeInSeconds);
    }

    static void recursiveBubbleSort(long[] array, int size) {
        if (size == 1) {
            return;
        }
        else {
            for (int i = 0; i < size-1; i++) {
                if (array[i] > array[i+1]) {
                    long temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            recursiveBubbleSort(array, size-1);
        }
    }

    static void recursiveSelectionSort(long[] array, int size) {
        if (size == 1) {
            return;
        } else {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (array[maxIndex] < array[i]) {
                    maxIndex = i;
                }
            }
            long temp = array[maxIndex];
            array[maxIndex] = array[size-1];
            array[size-1] = temp;
            recursiveSelectionSort(array, size-1);
        }


    }

    static long factorial(long n) {
        if (n == 0) {
            return 1L;
        }
        else {
            return n*factorial(n-1);
        }
    }

    static long fibonacciNumber(int n) {
        if (n == 1 || n==2) {
            return 1;
        } else {
            return fibonacciNumber(n-1) + fibonacciNumber(n-2);
        }
    }
}
