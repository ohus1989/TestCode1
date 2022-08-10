package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_16 {
    public static void main(String[] args) throws IOException {
        // case 1
        int N = 7;
        int[][] relation = {{1,2},{4,2},{3,1},{4,5},{6,7}};
//        int N = 5;
//        int[][] relation = {{1, 2}, {4, 2}, {3, 1}, {4, 5}};
        System.out.println(solution(N, relation));
    }

    public static int[] solution(int N, int[][] relation) {
        int[] answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            int[][] temp = new int[relation.length][2];
            System.arraycopy(relation, 0, temp, 0, relation.length);
            List<Integer> partnerInts = new ArrayList<>();
            int cnt = 0;
            Boolean mode = false;
            for (int j = 0; j < temp.length; j++) {
                if (!mode && (temp[j][0] == i + 1 || temp[j][1] == i + 1)) {
                    if (temp[j][0] == i + 1) {
                        partnerInts.add(temp[j][1]);
                    } else {
                        partnerInts.add(temp[j][0]);
                    }
                    int[][] temp2 = new int[temp.length - 1][2];
                    System.arraycopy(temp, 0, temp2, 0, j);
                    if (temp2.length != j) {
                        System.arraycopy(temp, j + 1, temp2, j, temp.length - j - 1);
                    }
                    temp = temp2;

                    j--;
                    cnt++;
                }else if(mode){
                    for(int partnerInt : partnerInts){
                        if(temp[j][0] == partnerInt || temp[j][1] == partnerInt){
                            int[][] temp2 = new int[temp.length - 1][2];
                            System.arraycopy(temp, 0, temp2, 0, j);
                            if (temp2.length != j) {
                                System.arraycopy(temp, j + 1, temp2, j, temp.length - j - 1);
                            }
                            temp = temp2;
                            cnt++;
                        }
                    }
                }

                if (j == temp.length - 1 && temp.length > 0 && !mode && !partnerInts.isEmpty()) {
                    j = -1;
                    mode = true;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}

