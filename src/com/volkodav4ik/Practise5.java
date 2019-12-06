package com.volkodav4ik;

import java.util.Random;

public class Practise5 {

    private static final int ARRAY_LENTH_AND_VALUE = 1000000;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] arr = new int[ARRAY_LENTH_AND_VALUE];
        createAndInitArray(arr);

        int[] quickArr = new int[arr.length];
        System.arraycopy(arr, 0, quickArr, 0, arr.length);
        long timeQuick = System.currentTimeMillis();
        int low = 0;
        int high = quickArr.length - 1;
        quickSort(quickArr, low, high);
        timeQuick = System.currentTimeMillis() - timeQuick;
        System.out.println("Time of Quick sort is " + timeQuick / 1000.0 + " s");

        int[] heapArr = new int[arr.length];
        System.arraycopy(arr, 0, heapArr, 0, arr.length);
        long timeHeap = System.currentTimeMillis();
        heapSort(heapArr);
        timeHeap = System.currentTimeMillis() - timeHeap;
        System.out.println("Time of Heap sort is " + timeHeap / 1000.0 + " s");


        int[] mergeArr = new int[arr.length];
        System.arraycopy(arr, 0, mergeArr, 0, arr.length);
        long timeMerge = System.currentTimeMillis();
        mergeArr = mergeSort(mergeArr);
        timeMerge = System.currentTimeMillis() - timeMerge;
        System.out.println("Time of Merge sort is " + timeMerge / 1000.0 + " s");

    }

    private static void quickSort(int[] quickArr, int low, int high) {
        if (quickArr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int support = quickArr[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (quickArr[i] < support) {
                i++;
            }
            while (quickArr[j] > support) {
                j--;
            }
            if (i <= j) {
                swap(quickArr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(quickArr, low, j);
        }
        if (high > i) {
            quickSort(quickArr, i, high);
        }
    }

    private static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, length, largest);
        }
    }

    private static int[] mergeSort(int[] arrayA) {
        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);
        arrayB = mergeSort(arrayB);
        arrayC = mergeSort(arrayC);
        return mergeArray(arrayB, arrayC);
    }

    private static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayC;
    }

    private static void createAndInitArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RANDOM.nextInt(ARRAY_LENTH_AND_VALUE);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
