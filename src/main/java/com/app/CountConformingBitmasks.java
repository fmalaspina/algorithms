package com.app;

import org.junit.Test;

public class CountConformingBitmasks {
    int maxLength = 0;
    public int solution(int A, int B, int C) {
        // Implement your solution here
        System.out.println(Integer.toBinaryString(A).length());
        System.out.println(Integer.toBinaryString(B));
        System.out.println(Integer.toBinaryString(C));
        System.out.println(Integer.toBinaryString(A | B | C));
    return (A & B & C);
    }



    @Test
    public void test() {
        CountConformingBitmasks solution = new CountConformingBitmasks();
        int A = 1_073_741_727;
        int B = 1_073_741_631;
        int C = 1_073_741_679;
        int result = solution.solution(A,B,C);
        System.out.println(result);
    }
}