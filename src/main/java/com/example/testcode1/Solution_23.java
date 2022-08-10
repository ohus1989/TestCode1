package com.example.testcode1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_23 {
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
        int bulletLength = bullets.length;
        List<Float> bulletList = new ArrayList<>();
        for (int i = 0; i < bulletLength; i++) {
            bulletList.add(DSP.atan2_accurate(bullets[i][1], bullets[i][0]));
        }
        float angle;
        for (int[] monster : monsters) {
            angle = DSP.atan2_accurate(monster[1], monster[0]);
            for (int i = 0; i < bulletList.size(); i++) {
                if (bulletList.get(i) == angle) {
                    bulletList.remove(i);
                    result++;
                    break;
                }
            }
        }
        return result == 0 ? -1 : result;
    }

    public static final class DSP {

        private static final float coeff_1 = (float) Math.PI / 4;
        private static final float coeff_2 = coeff_1 * 3;

        public static final float atan2_accurate(float y, float x) {
            float r;
            if (y < 0) {
                y = -y;
                if (x > 0) {
                    r = (x - y) / (x + y);
                    return (float) -(0.1963 * r * r * r - 0.9817 * r + coeff_1);
                } else {
                    r = (x + y) / (y - x);
                    return (float) -(0.1963 * r * r * r - 0.9817 * r + coeff_2);
                }
            } else {
                if (y == 0) {
                    y = (float) 1.0E-25;
                }
                if (x > 0) {
                    r = (x - y) / (x + y);
                    return (float) (0.1963 * r * r * r - 0.9817 * r + coeff_1);
                } else {
                    r = (x + y) / (y - x);
                    return (float) (0.1963 * r * r * r - 0.9817 * r + coeff_2);
                }
            }
        }
    }
}

