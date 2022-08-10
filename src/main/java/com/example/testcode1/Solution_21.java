package com.example.testcode1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_21 {
    public static void main(String[] args) throws IOException {
        // case 1
        int[][] monsters = {{2, 3}, {4, 5}, {3, -3}, {2, -4}, {3, -6}, {-3, -3}, {-5, 0}, {-4, 4}};
        int[][] bullets = {{4, 1}, {4, 6}, {1, -2}, {-4, -4}, {-3, 0}, {-4, 4}};
        //case 2
//        int[][] monsters = {{-4,4},{-2,2},{6,2},{0,-2}};
//        int[][] bullets = {{3,1},{-1,1},{-1,1},{0,-4},{2,-3}};
//        int[][] monsters = {{1,2},{-2,-1},{1,-2},{3,-1}};
//        int[][] bullets = {{1,0},{2,1}};
        System.out.println(solution(monsters, bullets));
    }

    public static int solution(int[][] monsters, int[][] bullets) {
        int result = 0;
        for (int[] monster : monsters) {
            for (int i = 0; i < bullets.length; i++) {
                if ((monster[0] == 0 && bullets[i][0] != 0)
                        || (monster[0] != 0 && bullets[i][0] == 0)
                        || (monster[1] == 0 && bullets[i][1] != 0)
                        || (monster[1] != 0 && bullets[i][1] == 0)
                        || (monster[1] > 0 && bullets[i][1] < 0)
                        || (monster[0] > 0 && bullets[i][0] < 0)
                        || (monster[1] < 0 && bullets[i][1] > 0)
                        || (monster[0] < 0 && bullets[i][0] > 0)
                ) {
                    continue;
                }
                if (
                        (monster[0] == 0 && bullets[i][0] == 0 && ((monster[1] > 0 && bullets[i][1] > 0) || (monster[1] < 0 && bullets[i][1] < 0)))
                                || (monster[1] == 0 && bullets[i][1] == 0 && ((monster[0] > 0 && bullets[i][0] > 0) || (monster[0] < 0 && bullets[i][0] < 0)))
                ) {
                    int[][] temp = new int[bullets.length - 1][2];
                    System.arraycopy(bullets, 0, temp, 0, temp.length);
                    if (temp.length != i) {
                        System.arraycopy(bullets, i + 1, temp, i, bullets.length - i - 1);
                    }
                    bullets = temp;
                    result++;
                    break;
                }
                double a = monster[0] / bullets[i][0] * 1.0;
                double b = monster[1] / bullets[i][1] * 1.0;
                if (a == b) {
                    int[][] temp = new int[bullets.length - 1][2];
                    System.arraycopy(bullets, 0, temp, 0, temp.length);
                    if (temp.length != i) {
                        System.arraycopy(bullets, i + 1, temp, i, bullets.length - i - 1);
                    }
                    bullets = temp;
                    result++;
                    break;
                }
            }
        }
        return result == 0 ? -1 : result;
    }


}

