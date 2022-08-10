package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_18 {
    public static void main(String[] args) throws IOException {
        // case 1
        int N = 7;
        int[][] relation = {{1,2},{4,2},{3,1},{4,5},{6,7}};
//        int[][] relation = {{1,2},{4,2},{3,2},{3,1},{4,5},{6,7}};
//        int N = 12;
//        int[][] relation = {{1, 2}, {2, 4}, {3, 1}, {3, 11}, {4, 5}, {5, 8}, {5, 10}, {6, 7}, {8, 9}};
//        int N = 5;
//        int[][] relation = {{1, 2}, {4, 2}, {3, 1}, {4, 5}};
        System.out.println(solution(N, relation));
    }

    public static int[] solution(int N, int[][] relation) {
        int[] answer = new int[N];


        List<int[]> array = new ArrayList<>();
        for (int[] item : relation) {
            Arrays.sort(item);
        }

        for (int[] item : relation) {
            if (!array.contains(item)) {
                array.add(item);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            List<Integer> partners = new ArrayList<>();
            for (int[] item : array) {
                if (item[0] == i + 1) {
                    partners.add(item[1]);
                } else if (item[1] == i + 1) {
                    partners.add(item[0]);
                }
            }
            for (int[] item : array) {
                if (item[0] == i + 1 || item[1] == i + 1 ||
                        (partners.contains(item[0]) && !partners.contains(item[1]))
                        ||
                        (!partners.contains(item[0]) && partners.contains(item[1]))) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}

