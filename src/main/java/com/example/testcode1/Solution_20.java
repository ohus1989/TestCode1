package com.example.testcode1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_20 {
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
        Double[] bulletList = new Double[bullets.length];
        for (int i = 0; i < bullets.length; i++) {
            bulletList[i] = DSP.atan2_accurate(bullets[i][1], bullets[i][0]);
        }
        double angle1, angle2;
        for (int[] monster : monsters) {
            angle2 = DSP.atan2_accurate(monster[1], monster[0]);
            for (int i = 0; i < bulletList.length; i++) {
                angle1 = bulletList[i];
                if (angle1 == angle2) {
                    Double[] temp = new Double[bulletList.length - 1];
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

        private static final double coeff_1 = Math.PI / 4;
        private static final double coeff_2 = coeff_1 * 3;

        public static final double atan2_accurate(double y, double x) {
            double r;
            if (y < 0) {
                y = -y;
                if (x > 0) {
                    r = (x - y) / (x + y);
                    return -(0.1963 * r * r * r - 0.9817 * r + coeff_1);
                } else {
                    r = (x + y) / (y - x);
                    return -(0.1963 * r * r * r - 0.9817 * r + coeff_2);
                }
            } else {
                if (y == 0) {
                    y = 1.0E-25;
                }
                if (x > 0) {
                    r = (x - y) / (x + y);
                    return 0.1963 * r * r * r - 0.9817 * r + coeff_1;
                } else {
                    r = (x + y) / (y - x);
                    return 0.1963 * r * r * r - 0.9817 * r + coeff_2;
                }
            }
        }
    }
}

