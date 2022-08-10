package com.example.testcode1;

import java.io.IOException;

class Solution_25 {
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
            bulletList[i] = bullets[i][1]/bullets[i][0];
        }
        for (int j = monsters.length - 1; j >= 0; j--) {
            for (int i = bullets.length - 1; i >= 0; i--) {
                if(
                        (monsters[j][0] == 0 && bullets[i][0] != 0) ||
                        (monsters[j][0] != 0 && bullets[i][0] == 0) ||
                        (monsters[j][1] == 0 && bullets[i][1] != 0) ||
                        (monsters[j][1] != 0 && bullets[i][1] == 0) ||
                        (monsters[j][0] > 0 && bullets[i][0] < 0) ||
                        (monsters[j][0] < 0 && bullets[i][0] > 0)
                ){
                    continue;
                }
                if (monsters[j][0]*bullets[i][1] == monsters[j][1]*bullets[i][0]) {
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

