package com.volkodav4ik;

import java.util.Random;

public class Practise4 {

    private static final int ARRAY_LENTH_AND_VALUE = 100000;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] arr = new int[ARRAY_LENTH_AND_VALUE];
        createAndInitArray(arr);

        int[] arrBubble = new int[arr.length];
        System.arraycopy(arr, 0, arrBubble, 0, arr.length);
        long timeBubble = System.currentTimeMillis();
        bubbleSort(arrBubble);
        timeBubble = System.currentTimeMillis() - timeBubble;
        System.out.println("Time of Bubble sort is " + timeBubble / 1000.0 + " s");

        int[] arrInsertion = new int[arr.length];
        System.arraycopy(arr, 0, arrInsertion, 0, arr.length);
        long timeInsertion = System.currentTimeMillis();
        insertionSort(arrInsertion);
        timeInsertion = System.currentTimeMillis() - timeInsertion;
        System.out.println("Time of Insertion sort is " + timeInsertion / 1000.0 + " s");

        long timeSelect = System.currentTimeMillis();
        int[] arrSelect = new int[arr.length];
        System.arraycopy(arr, 0, arrSelect, 0, arr.length);
        selectSort(arrSelect);
        timeSelect = System.currentTimeMillis() - timeSelect;
        System.out.println("Time of Selection sort is " + timeSelect / 1000.0 + " s");
    }

    private static void bubbleSort(int[] arr) {
        boolean isSorted;
        for (int i = 0; i < arr.length; i++) {
            isSorted = true;
            for (int j = 1; j <= (arr.length - 1); j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while ((j > -1) && (arr[j] > tmp)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                swap(arr, i, min_i);
            }
        }
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