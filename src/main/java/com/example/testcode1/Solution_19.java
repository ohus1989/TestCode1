package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_19 {
    public static void main(String[] args) throws IOException {
        // case 1
        int[][] monsters = {{2, 3}, {4, 5}, {3, -3}, {2, -4}, {3, -6}, {-3, -3}, {-5, 0}, {-4, 4}};
        int[][] bullets = {{4, 1}, {4, 6}, {1, -2}, {-4, -4}, {-3, 0}, {-4, 4}};
//        int[][] monsters = {{-4,4},{-2,2},{6,2},{0,-2}};
//        int[][] bullets = {{3,1},{-1,1},{-1,1},{0,-4},{2,-3}};
        System.out.println(solution(monsters, bullets));
    }

    public static int solution(int[][] monsters, int[][] bullets) {
        int result = 0;
        List<Double[]> monsterList = new ArrayList<>();
        List<Double> bulletList = new ArrayList<>();
        for (int[] monster : monsters) {
            Double[] addD = new Double[2];
            addD[0] = (monster[0] * monster[0] + monster[1] * monster[1]) * 1.0;
            addD[1] = Math.atan2(monster[1], monster[0]);
            monsterList.add(addD);
        }
        for (int[] bullet : bullets) {
            bulletList.add(Math.atan2(bullet[1], bullet[0]));
        }
        Collections.sort(monsterList, (o1, o2) -> {
            double d1 = o1[0];
            double d2 = o2[0];
            if (d1 > d2) {
                return 1;
            } else if (d1 < d2) {
                return -1;
            } else {
                return 0;
            }
        });
        for (Double[] item : monsterList) {
            for (int i = 0; i < bulletList.size(); i++) {
                double angle1 = bulletList.get(i);
                double angle2 = item[1];
                if (angle1 == angle2) {
                    bulletList.remove(i);
                    result++;
                    break;
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}

