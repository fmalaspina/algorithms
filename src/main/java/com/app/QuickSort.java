package com.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import static java.util.stream.Stream.concat;

public class QuickSort {
    public List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() < 2) return arr;
        else {
            int pivot = arr.getFirst();
            List<Integer> less = arr.stream().filter(e -> e < pivot).toList();
            List<Integer> greater = arr.stream().filter(e -> e > pivot).toList();
            return concat(quickSort(less).stream(), concat(Stream.of(pivot), quickSort(greater).stream())).toList();
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {10, 7, 8, 9, 1, 5};
        var res = quickSort.quickSort(Arrays.stream(arr).boxed().toList());
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr2 = {};
        var res2 = quickSort.quickSort(Arrays.stream(arr2).boxed().toList());
        for (int i : res2) {
            System.out.print(i + " ");
        }
    }
}
