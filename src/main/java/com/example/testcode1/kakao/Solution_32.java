package com.example.testcode1.kakao;

import java.io.IOException;

class Solution_32 {
    public static void main(String[] args) throws IOException {
        int[] A = {1,2,3};
//        int[] A = {7, -5, -5, -5, 7,-5, 7, -1, 7};
//        int[] A = {7,4,-2,4,-2,-9};
//        int[] A = {5,5,4,5,4};
//        int[] A = {3, 2, 3, 2, 3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int oddTarget = 1000000001;
        int evenTarget = 1000000001;
        int maxCnt = 0;
        int oddCnt = 0;
        int evenCnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] == evenTarget) {
                    evenCnt++;
                } else {
                    evenTarget = A[i];
                    if(oddCnt > 1){
                        oddCnt -= evenCnt;
                    }
                    evenCnt = 1;
                }
            } else {
                if (A[i] == oddTarget) {
                    oddCnt++;
                } else {
                    oddTarget = A[i];
                    if(evenCnt > 1){
                        evenCnt -= (oddCnt -1);
                    }
                    oddCnt = 1;
                }
            }
            if (maxCnt < oddCnt + evenCnt) {
                maxCnt = oddCnt + evenCnt;
            }
        }
        return maxCnt;
    }

}

