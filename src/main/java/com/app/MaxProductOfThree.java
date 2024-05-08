package com.app;
import java.util.Arrays;
import java.util.TreeSet;

public class MaxProductOfThree {


        public int solution(int[] A) {
           Arrays.sort(A);
            int largest = A[A.length - 1];
            int smallest = A[0];

            int result = Math.max(largest * smallest * A[1], largest * A[A.length - 2] * A[A.length - 3]);
            return result;
        }



    public static void main(String[] args) {
        MaxProductOfThree solution = new MaxProductOfThree();
        int[] A = {-5, 5, -5, 4};

       var result = solution.solution(A);
        System.out.println(result);
    }

}
