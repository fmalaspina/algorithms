package com.app;

import org.junit.Test;

public class TreeLongestZigZag {
    int maxLength = 0;
    public int solution(Tree T) {
        // Implement your solution here
        findLongestZigZag(T,2,0);
        findLongestZigZag(T,2,0);
        return maxLength;
    }

    private void findLongestZigZag(Tree t, int dir, int currentLength) {
        if (t == null) return;
        maxLength = Math.max(maxLength,currentLength);
        if (t.l != null) findLongestZigZag(t.l,0,dir==1?currentLength+1:1);
        if (t.r != null) findLongestZigZag(t.r,1,dir==0?currentLength+1:1);
    }

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    @Test
    public void test1() {
        Tree t = new Tree();
        t.x = 1;
        t.l = new Tree();
        t.l.x = 2;
        t.r = new Tree();
        t.r.x = 3;
        t.l.l = new Tree();
        t.l.l.x = 4;
        t.l.r = new Tree();
        t.l.r.x = 5;
        t.r.l = new Tree();
        t.r.l.x = 6;
        t.r.r = new Tree();
        t.r.r.x = 7;
        int result = solution(t);
        System.out.println(result);
    }
    @Test
    public void test2() {
        Tree t = new Tree();
        t.x = 1;
        t.l = new Tree();
        t.l.x = 2;
        t.l.r = new Tree();
        t.l.r.x = 3;
        t.l.r.l = new Tree();
        t.l.r.l.x = 4;
        int result = solution(t);
        System.out.println(result);
    }
}