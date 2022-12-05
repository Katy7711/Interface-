package com.skypro.Interface.Interface;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static com.skypro.Interface.Interface.IntegerListImpl.swapElements;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class SortComparison {
    public static void main(String[] args) {
        int[] array = generateRandomArray();
        benchmarkSort(Arrays.copyOf (array, array.length), SortComparison::sortBubble);
        benchmarkSort(Arrays.copyOf (array, array.length), SortComparison::sortSelection);
        benchmarkSort(Arrays.copyOf (array, array.length), SortComparison::sortInsertion);
        benchmarkSort(Arrays.copyOf (array, array.length), SortComparison::quickSort);

        long start = System.currentTimeMillis();
        sortBubble(array);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(isSorted(array));

    }
    private static void benchmarkSort(int[] array, Consumer<int[]> sortFunction){
        long start = System.currentTimeMillis();
        sortFunction.accept(array);
        long end = System.currentTimeMillis();
        System.out.println("is sorted " + isSorted(array));
        System.out.println("execution time " + (end - start) + " ms");
    }
    private static int[] generateRandomArray (){
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(0,1_000_000))
                .limit(100_000).toArray();
    }

    private static void sortBubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                }
            }
        }
    }
    private static void sortSelection(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(array, i, minElementIndex);
        }
    }
    private static void sortInsertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

}




