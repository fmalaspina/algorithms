package com.app;
/*
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 TESTED 100% AND WORKS FINE
*/
import java.util.Arrays;
import java.util.stream.Collectors;

public class MissingInteger {
    public int solution(int[] A) {
        // Implement your solution here
        int[] sorted = Arrays.stream(A).filter(i -> i >= 0).sorted().distinct().toArray();

        for (int i = 0; i < sorted.length; i++) {

                if (i == 0 && sorted[i] > 1) {
                    return 1;
                } else if (i > 0 && sorted[i] - sorted[i - 1] > 1) {
                    return sorted[i-1]+1;
                }

        }

        int res = sorted[sorted.length-1] + 1;
        if (res > 0) {
            return res;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        int[] A = {2, 3, 6, 4, 1, 2};
        int result = missingInteger.solution(A);
        System.out.println(result);
    }
}
