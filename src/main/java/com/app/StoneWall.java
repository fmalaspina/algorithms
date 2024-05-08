package com.app;

/*
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S is made only of the characters '(' and/or ')'.


 TESTED AND WORKS FINE 100%


 */
import java.util.Stack;

class StoneWall {
    public int solution(int[] H) {

        if (H.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (int i : H) {
            if (stack.isEmpty()) {
                stack.push(H[i]);
                count++;
            } else {
                if (H[i] > stack.peek()) {
                    stack.push(H[i]);
                    count++;
                } else if (H[i] < stack.peek()) {
                    while (!stack.isEmpty() && H[i] < stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || H[i] > stack.peek()) {
                        stack.push(H[i]);
                        count++;
                    }
                }
            }
        }
        return count;



    }

    public static void main(String[] args) {
        StoneWall solution = new StoneWall();
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        int result = solution.solution(H);
        System.out.println(result);

    }
}

