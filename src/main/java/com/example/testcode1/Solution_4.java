package com.example.testcode1;

import java.io.IOException;

class Solution_4 {
    public static void main(String[] args) throws IOException {
        Solution_4 solution = new Solution_4();
        int n = 7;
        int[][] del = {{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}};
//        int n = 6;
//        int[][] del = {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}};
        String answer = solution.solution(n, del);
        System.out.println();
    }

    public String solution(int n, int[][] del) {
        int[] status = new int[n];
        for (int[] item : del) {
            if (item[2] == 1) {
                status[item[0] - 1] = 1;
                status[item[1] - 1] = 1;
            } else {
                if (status[item[0] - 1] <= 0) {
                    status[item[0] - 1]--;
                }
                if (status[item[1] - 1] <= 0) {
                    status[item[1] - 1]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int b : status) {
            if (b == 0 || b == -1) {
                sb.append("?");
            } else if (b < -1) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    }

}

