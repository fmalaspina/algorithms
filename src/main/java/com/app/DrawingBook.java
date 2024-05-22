package com.app;

import org.junit.Test;

public class DrawingBook {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {


        return Math.min(dfs(0,p,0), dfs(p,n,0));

    }

    private static int dfs(int start, int end,int acum) {
        if (start >= end) return acum;

        if (start < end) {
            // si es pagina 0 o par sumo dos
            if (start % 2 != 0) {

                acum++;
            }
        }
        return dfs(start+1,end,acum);



    }
    @Test
    public void test() {
        assert(DrawingBook.pageCount(5,4)==0);
        assert(DrawingBook.pageCount(6,2)==1);
    }

}