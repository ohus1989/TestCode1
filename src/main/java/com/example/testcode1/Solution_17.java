package com.example.testcode1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_17 {
    public static void main(String[] args) throws IOException {
        // case 1
//        int N = 7;
//        int[][] relation = {{1,2},{4,2},{3,1},{4,5},{6,7}};
        int N = 5;
//        int[][] relation = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}};
        int[][] relation = {{1, 2}, {4, 2}, {3, 2}, {3, 1}, {4, 5}};
        System.out.println(solution(N, relation));
    }

    public static int[] solution(int N, int[][] relation) {
        int[] answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            List<Integer> partners = new ArrayList<>();
            for(int[] item : relation){
                if(item[0] == i+1){
                    partners.add(item[1]);
                }else if(item[1] == i+1){
                    partners.add(item[0]);
                }
            }
            List<Integer> real = new ArrayList<>();
            for(int[] item : relation){
                if(item[0] == i+1 || item[1] == i+1 ||
                        (partners.contains(item[0]) && !partners.contains(item[1]))
                        ||
                        (!partners.contains(item[0]) && partners.contains(item[1]))) {
                    if(!real.contains(item[1]) && item[1] != i +1){
                        real.add(item[1]);
                    }
                    if(!real.contains(item[0]) && item[0] != i +1){
                        real.add(item[0]);
                    }
                }
            }
            answer[i] = real.size();
        }
        return answer;
    }
}

