package com.example.testcode1.socar;

import java.io.IOException;

class Solution_45 {
    public static void main(String[] args) throws IOException {
        Solution solution =new Solution();
        int n = 5;
        int k = 4;
        int[][] paths = {{1, 5, 1, 1}, {1, 2, 4, 3}, {1, 3, 3, 2}, {2, 5, 2, 1}, {2, 4, 2, 3}, {3, 4, 2, 2}};
        solution.solution(n,k,paths);
    }
}
