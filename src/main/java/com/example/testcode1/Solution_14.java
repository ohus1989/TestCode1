package com.example.testcode1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_14 {
    public static void main(String[] args) throws IOException {
        int x = -1;
        int y = 2;
        int r = 2;
        int d = 60;
        int[][] target = {{0, 1}, {-1, 1}, {1, 0}, {-2, 2}};
        System.out.println(solution(x, y, r, d, target));
    }

    public static int solution(int x, int y, int r, int d, int[][] target) {
        int result = 0;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            if (distance(target[i][0], target[i][1]) <= r) {
                list.add(target[i]);
            }
        }
        double u, v, inner, theta;
        for (int i = 0; i < list.size(); i++) {
            u = distance(x, y);
            v = distance(list.get(i)[0], list.get(i)[1]);

            inner = innerFun(x, y, list.get(i)[0], list.get(i)[1]);

            theta = Math.acos(inner / (u * v));

            if (theta <= Math.toRadians(d)) {
                result++;
            }
        }
        return result;
    }

    public static double distance(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double innerFun(double x, double y, double x1, double y1) {
        return (x * x1) + (y * y1);
    }

}

