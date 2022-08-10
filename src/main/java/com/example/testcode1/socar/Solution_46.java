package com.example.testcode1.socar;

import java.io.IOException;

class Solution_46 {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
//        String[][] map3d = {{"XXXXX", "OOSXO", "OOXOO"}, {"XEOOO", "OXXXO", "OOOOX"}};
        String[][] map3d = {{"SOXX","OOXX"}, {"XXOO", "XXOE"}};
//        String[][] map3d = {{"OOOOO","OOOOO","OOEOO","OOOOO","OOOOO"},
//                {"OOOOO", "OXXXO","OXXXO","OXXXO","OOOOO"},
//                {"OOOOO", "OOOOO","OOSOO","OOOOO","OOOOO"}
//        };

        System.out.println(solution(map3d));
    }

    public static int solution(String[][] map3d) {
        int x = map3d.length;
        int y = map3d[0].length;
        int z = map3d[0][0].length();
        String[][][] maps = new String[x][y][z];
        boolean[][][] visited = new boolean[x][y][z];
        int[] answer = {-1};
//        int answer = -1;
        int depth = 0;
        int[] start = new int[3];
        int[] end = new int[3];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    maps[i][j][k] = map3d[i][j].substring(k, k + 1);
                    if (maps[i][j][k].equals("S")) {
                        start[0] = i;
                        start[1] = j;
                        start[2] = k;
                    } else if (maps[i][j][k].equals("E")) {
                        end[0] = i;
                        end[1] = j;
                        end[2] = k;
                    }
                }
            }
        }
        dfs(start, end, maps, visited, depth, answer);
        return answer[0];
    }

    public static void dfs(int[] start, int[] end, String[][][] maps, boolean[][][] visited, int depth, int[] answer) {
        int xl = maps.length;
        int yl = maps[0].length;
        int zl = maps[0][0].length;
        if (start[0] == end[0] && start[1] == end[1] && start[2] == end[2]) {
            if (answer[0] == -1){
                answer[0] = depth;
                start[0] = -1;
                start[1] = -1;
                start[2] = -1;
            }else{
                answer[0] = answer[0] > depth ? depth : answer[0];
            }
            return;
        }

        for (int i = 0; i < 6; i++) {
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];
            int nz = start[2] + dz[i];
            if (nx >= 0 && ny >= 0 && nz >= 0 && nx < xl && ny < yl && nz < zl) {
                if ((maps[nx][ny][nz].equals("O") || maps[nx][ny][nz].equals("E")) && !visited[nx][ny][nz]) {
//                    if(answer[0] == 9){
//                        System.out.println("i: " + i + ", x: " + nx + ", y: " + ny + ", z:" + nz + ", answer: " + answer[0]);
//                    }
//                    System.out.println("i: " + i + ", x: " + nx + ", y: " + ny + ", z:" + nz + ", answer: " + answer[0]);
                    visited[nx][ny][nz] = true;
                    start[0] += dx[i];
                    start[1] += dy[i];
                    start[2] += dz[i];
                    dfs(start, end, maps, visited, depth + 1, answer);
                    visited[nx][ny][nz] = false;
                }
            }
        }
    }
}

