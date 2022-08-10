package com.example.testcode1.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_33 {
    public static void main(String[] args) throws IOException {
        // case 1
//        int[] T = {0, 0, 1, 1};
//        int[] A = {2};

        // case 2
//        int[] T = {0,0,0,0,2,3,3};
//        int[] A = {2,5,6};
        // case 3
//        int[] T = {0,0,1,2};
//        int[] A = {1,2};

        // case 4
        int[] T = {0, 3, 0, 0, 5, 0, 5};
        int[] A = { 2, 6,  0};
//        int[] A = {4, 2, 6, 1, 0};
        System.out.println(solution(T, A));
    }

    public static int solution(int[] T, int[] A) {
        List<Integer> requireArray = new ArrayList<>();
        for (int i : A) {
            int index = i;
            while (index != 0) {
                if (!requireArray.contains(index)) {
                    requireArray.add(index);
                }else{
                    break;
                }
                index = T[index];
            }
        }
        return requireArray.size() + 1;
    }

}

