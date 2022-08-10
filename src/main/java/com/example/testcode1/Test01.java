package com.example.testcode1;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
    static int[][] max, min;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////        int N = sc.nextInt();
//        String s = sc.next();
        String s = "2-1x5-4x3+2";

        int N_MIN = s.length();
int N_MAX = s.length();
        max = new int[N_MIN][N_MAX];
        min = new int[N_MIN][N_MAX];

        for (int i = 0; i < N_MAX; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N_MAX; i++) {
            if (Character.isDigit(s.charAt(i))) {
                max[i][i] = min[i][i] = s.charAt(i) - '0';
            }
        }

        for (int j = 2; j < N_MAX; j += 2) {
            for (int i = 0; i < N_MAX - j; i += 2) {
                for (int k = 2; k <= j; k += 2) {
                    int[] tmp = new int[4];
                    tmp[0] = cal(min[i][i + k - 2], min[i + k][i + j], s.charAt(i + k - 1));
                    tmp[1] = cal(min[i][i + k - 2], max[i + k][i + j], s.charAt(i + k - 1));
                    tmp[2] = cal(max[i][i + k - 2], min[i + k][i + j], s.charAt(i + k - 1));
                    tmp[3] = cal(max[i][i + k - 2], max[i + k][i + j], s.charAt(i + k - 1));

                    Arrays.sort(tmp);

                    min[i][i + j] = Math.min(min[i][i + j], tmp[0]);
                    max[i][i + j] = Math.max(max[i][i + j], tmp[3]);
                }
            }
        }

        System.out.println(max[0][N_MAX - 1]);
    }

    static int cal(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}
