package com.app;

class BinnaryZeros {

    int max = 0;
    public int solution(int N) {
        int max = 0;
        int count = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                N>>=1;
                while (N > 0 && (N & 1) == 0) {
                    count++;
                    N>>=1;
                }
                if ((N & 1) == 1) {
                    if (count > max) max = count;
                    count = 0;
                }

            } else {
                N>>=1;
            }

        }
        return max;
    }
}