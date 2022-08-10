package com.example.testcode1;

import java.io.IOException;
import java.util.StringTokenizer;

class Solution_7 {
    static StringTokenizer st;
    static int N;
    static int M;
    static String[] dots;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{

        // 주어진 값들 저장
        N = 3;
        M = 4;

        dots = new String[]{"AAAA", "ABCA","AADA"};
        visited = new boolean[N][M];

        // 각 위치에서 DFS 탐색 수행
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){

                // 이전에 방문했다면 그 색상이 지나는 인접 정점은 전부 Cycle이 없는 것
                if(visited[i][j]) continue;
                if(dfs(-1, -1, i, j)){
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");

    }

    private static boolean dfs(int by, int bx, int cy, int cx){

        // 기 방문된 곳이라면 Cycle이 있는 것!
        if(visited[cy][cx]){ return true; }
        visited[cy][cx] = true;

        for(int i=0; i < 4; i++){
            int ny = cy + dy[i];
            int nx = cx + dx[i];

            // 범위 안에 있고 이전 정점으로 되돌아가는 것이 아니며, 같은 색상이면 dfs 추가 탐색
            if(!(0 <= ny && ny < N && 0 <= nx && nx < M)) continue;
            if(ny == by && nx == bx) continue;
            if(dots[cy].charAt(cx) == dots[ny].charAt(nx)){
                if(dfs(cy, cx, ny, nx)){
                    return true;
                }
            }
        }
        return false;
    }

}

