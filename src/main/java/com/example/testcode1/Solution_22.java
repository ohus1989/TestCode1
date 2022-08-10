package com.example.testcode1;

import java.io.IOException;

class Solution_22 {
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
        float[] bulletList = new float[bulletLength];
        for (int i = 0; i < bulletLength; i++) {
            bulletList[i] = DSP.atan2_accurate(bullets[i][1], bullets[i][0]);
        }
        float angle1, angle2;
        for (int j = monsters.length - 1; j >= 0; j--) {
            angle2 = DSP.atan2_accurate(monsters[j][1], monsters[j][0]);
            for (int i = bulletList.length - 1; i >= 0; i--) {
                angle1 = bulletList[i];
                if (angle1 == angle2) {
                    bulletList[i] = 0;
                    float[] temp = new float[bulletList.length - 1];
                    System.arraycopy(bulletList, 0, temp, 0, temp.length);
                    if (temp.length != i) {
                        System.arraycopy(bulletList, i + 1, temp, i, bulletList.length - i - 1);
                    }
                    bulletList = temp;
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
        private static final float coeff_3 = 0.19f;
        private static final float coeff_4 = 0.98f;
//        private static final double coeff_3 = 0.1963;
//        private static final double coeff_4 = 0.9817;

        public static final float atan2_accurate(float y, float x) {
            float r;
            if (y < 0) {
                y = -y;
                if (x > 0) {
                    r = (x - y) / (x + y);
                    return  -(coeff_3 * r * r * r - coeff_4 * r + coeff_1);
                } else {
                    r = (x + y) / (y - x);
                    return  -(coeff_3 * r * r * r - coeff_4 * r + coeff_2);
                }
            } else {
                if (y == 0) {
                    y = 1.0E-25f;
                }
                if (x > 0) {
                    r = (x - y) / (x + y);
                    return  (coeff_3 * r * r * r - coeff_4 * r + coeff_1);
                } else {
                    r = (x + y) / (y - x);
                    return  (coeff_3 * r * r * r - coeff_4 * r + coeff_2);
                }
            }
        }
    }
}

