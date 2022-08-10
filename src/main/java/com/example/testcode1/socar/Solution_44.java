package com.example.testcode1.socar;

import java.io.IOException;

class Solution_44 {
    public static void main(String[] args) throws IOException {
        int n = 5;
        int k = 4;
        int[][] paths = {{1, 5, 1, 1}, {1, 2, 4, 3}, {1, 3, 3, 2}, {2, 5, 2, 1}, {2, 4, 2, 3}, {3, 4, 2, 2}};
        Graph g = new Graph(n);
        for (int[] item : paths) {
            g.input(item);
        }
        System.out.println(g.dijkstra(1, k)[0] + " "+g.dijkstra(1, k)[1]);
    }

}

class Graph {
    private int n;
    int maps[][];
    int mileages[][];

    public Graph(int n) {
        this.n = n;
        maps = new int[n + 1][n + 1];
        mileages = new int[n + 1][n + 1];
    }

    public void input(int[] i) {
        maps[i[0]][i[1]] = i[2];
        maps[i[1]][i[0]] = i[2];
        mileages[i[0]][i[1]] = i[3];
        mileages[i[1]][i[0]] = i[3];
    }

    public int[] dijkstra(int start, int end) {
        int distance[] = new int[n + 1];
        int mileage[] = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        check[start] = true;
        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && maps[start][i] != 0) {
                distance[i] = maps[start][i];
                mileage[i] = mileages[start][i];
            }
        }
        for (int a = 0; a < n - 1; a++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            int maxMileage = Integer.MIN_VALUE;
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && distance[i] != Integer.MAX_VALUE) {
                    if (distance[i] < min) {
                        min = distance[i];
                        min_index = i;
                        maxMileage = mileage[i];
                    } else if (distance[i] == min) {
                        maxMileage = mileage[i];
                    }
                }
            }
            check[min_index] = true;
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && maps[min_index][i] != 0) {
                    if (distance[i] > distance[min_index] + maps[min_index][i]) {
                        distance[i] = distance[min_index] + maps[min_index][i];
                        mileage[i] =  mileage[min_index] + mileages[min_index][i];
                    }else if(distance[i] == distance[min_index] + maps[min_index][i] && mileage[i] < mileage[min_index] + mileages[min_index][i]){
                        mileage[i] =  mileage[min_index] + mileages[min_index][i];
                    }
                }
            }
        }
        return new int[]{distance[end], mileage[end]};
    }
}
