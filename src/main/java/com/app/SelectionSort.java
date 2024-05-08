package com.app;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class SelectionSort  {
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = Random.from(RandomGenerator.getDefault()).ints(20000,0,2000000).toArray();
        long start =  System.nanoTime();


        selectionSort.selectionSort(arr);
        long elapsedNanos =  System.nanoTime() - start;
        System.out.println(String.format("%d nanos", elapsedNanos));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
