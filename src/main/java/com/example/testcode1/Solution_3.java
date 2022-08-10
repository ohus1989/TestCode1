package com.example.testcode1;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Solution_3 {
    public static void main(String[] args) throws IOException {
        Solution_3 solution = new Solution_3();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] answer = solution.solution(lottos, win_nums);
        System.out.println();
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int sameCnt = 0;
        int zeroCnt = 0;
        int maxRank = 6;
        for (int s_num : lottos) {
            if (s_num == 0) {
                zeroCnt++;
                continue;
            }
            for (int w_num : win_nums) {
                if (w_num == s_num) {
                    sameCnt++;
                }
            }
        }

        int[] answer = {maxRank - ((sameCnt + zeroCnt) > 1 ? (sameCnt + zeroCnt) - 1 : 0)
                , maxRank - (sameCnt > 1 ? sameCnt - 1 : 0)};
        return answer;
    }
}

