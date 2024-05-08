package com.app;

import org.junit.Test;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CountInversionPairs {


        public int solution(int[] A) {
            //get number of inversions
            int inversions = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i] > A[j]) {
                        inversions++;
                        if (inversions > 1000000000) return -1;
                    }
                }
            }
            return inversions;

        }

        private int divide(int[]A, int low, int high, int inversions) {
            if (low >= high) return inversions;
            if (low + 1 == high) {
                if (A[low] > A[high]) {
                    int temp = A[low];
                    A[low] = A[high];
                    A[high] = temp;
                    inversions++;
                }

            }
            int mid = (low + high) / 2;
            inversions = divide(A, low, mid, inversions) + divide(A, mid + 1, high, inversions);

            return inversions;

        }

    public static void main(String[] args) {}

    @Test
    public void test() {
        CountInversionPairs solution = new CountInversionPairs();
        int[] A = {-1,6,3,4,7,4};
        int result = solution.solution(A);
        System.out.println(result);
    }
}