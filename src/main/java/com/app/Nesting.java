package com.app;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
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
class Nesting {
    public int solution(String S) {
        if (S.isEmpty()) return 1;
        Stack<Character> stack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                try {
                    if (c != stack.peek()) {
                        stack.pop();
                    }
                } catch (Exception e) {
                    return 0;
                }

            }
        }
        if (stack.isEmpty()) return 1;
        return 0;

    }

    public static void main(String[] args) {
        Nesting solution = new Nesting();
        String S = "(()(((())))";
        int result = solution.solution(S);
        System.out.println(result);
        S = "(()())";
        result = solution.solution(S);
        System.out.println(result);
        S = "";
        result = solution.solution(S);
        System.out.println(result);
    }
}

