package com.example.testcode1.socar;

import java.io.IOException;

class Solution_47 {
    int n, m, h;
    int[][][] map = new int[70][70][70];

    int[] dx = {1, -1, 0, 0, 0, 0};
    int[] dy = {0, 0, -1, 1, 0, 0};
    int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        String[][] map3d = {{"XXXXXX", "OOSXO", "OOXOO"}, {"XEOOO", "OXXXO", "OOOOX"}};

        System.out.println(solution(map3d));
    }

    public static int solution(String[][] map3d) {
        int answer = 0;
        return answer;
    }

//    public void dfs(int x, int y, int[][] maps, int depth) {
//        if (x == n - 1 && y == m - 1) {
//            if (dfs_answer == -1)
//                dfs_answer = depth;
//            else
//                dfs_answer = dfs_answer > depth ? depth : dfs_answer;
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
//                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
//                    visited[nx][ny] = true;
//                    dfs(nx, ny, maps, depth + 1);
//                    visited[nx][ny] = false;
//                }
//            }
//        }
//
//        return;
//
//    }
}

