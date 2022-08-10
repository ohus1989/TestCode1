package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_15 {
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
        List<Map<String, Double>> monsterList = new ArrayList<>();
        List<Map<String, Double>> bulletList = new ArrayList<>();
        for (int[] monster : monsters) {
            Map<String, Double> addMap = new HashMap<>();
            addMap.put("dist", (monster[0] * monster[0] + monster[1] * monster[1])*1.0);
            addMap.put("atan2", Math.atan2(monster[1], monster[0]));
            monsterList.add(addMap);
        }
        Collections.sort(monsterList, (o1, o2) -> {
            double d1 = o1.get("dist") * 1.0;
            double d2 = o2.get("dist") * 1.0;
            if (d1 > d2) {
                return 1;
            } else if (d1 < d2) {
                return -1;
            } else {
                return 0;
            }
        });
        for (Map<String, Double> item : monsterList) {
            for (int i = 0; i < bullets.length; i++) {
                double angle1 = Math.atan2(bullets[i][1], bullets[i][0]);
                double angle2 = item.get("atan2");
                if (angle1 == angle2) {
                    int[][] tempBullets = new int[bullets.length - 1][2];
                    System.arraycopy(bullets, 0, tempBullets, 0, i);
                    if (bullets.length != i) {
                        System.arraycopy(bullets, i + 1, tempBullets, i, bullets.length - i - 1);
                    }
                    bullets = tempBullets;
                    result++;
                    break;
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}

