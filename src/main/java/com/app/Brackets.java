package com.app;
import java.util.Deque;
import java.util.LinkedList;
class Brackets {
    public int solution(String S) {
        Deque<Character> deq = new LinkedList<Character>();
        for (char c : S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                deq.push(c);
            } else {
                if (deq.peek() == null) {
                    return 0;
                }
                char isClosing = deq.peek();
                if (c == '}' && isClosing == '{') {
                    deq.poll();
                }
                else if (c == ']' && isClosing == '[') {
                    deq.poll();
                }
                else if (c == ')' && isClosing == '(') {
                    deq.poll();
                }
                else {
                    return 0;
                }

            }
        }
        if (deq.isEmpty()) return 1;
        return 0;

    }
    public static void main(String[] args) {
        Brackets solution = new Brackets();
        String S = "{[(())]}";
        int result = solution.solution(S);
        System.out.println(result);
    }
}

