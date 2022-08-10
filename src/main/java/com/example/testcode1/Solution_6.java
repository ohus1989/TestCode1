package com.example.testcode1;

import java.io.IOException;

class Solution_6 {
    public static void main(String[] args) throws IOException {
        Solution_6 solution = new Solution_6();
        int[][] board = {
                {3, 2, 3, 2}
                , {2, 1, 1, 2}
                , {1, 1, 2, 1}
                , {4, 1, 1, 1}};
        int answer = solution.solution(board);
        System.out.println();
    }

    public int solution(int[][] board) {

        int answer = 7;
        int N = board[0].length;
        int M = board.length;
        boolean[][] visited = new boolean[N][M];
        int[][] status = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int chainCnt = status[i][j];
//                visited[i][j] = true;
                Boolean chainFlag = false;
                int MaxChineCnt = 0;
                dfs(visited, board, status, i, j, -1, -1);
//                if (i > 0) {
//                    if (!visited[i - 1][j] && board[i][j] == board[i - 1][j]) {
//                        chainFlag = true;
//                            visited[i - 1][j] = true;
//                        if(status[i][j] > status[i - 1][j]){
//                            status[i - 1][j] = status[i][j]+1;
//                        }
//                    }
//                    if (status[i - 1][j] > MaxChineCnt) {
//                        MaxChineCnt = status[i - 1][j];
//                        chainFlag = true;
//                    }
//                }
//                if (j > 0) {
//                    if (!visited[i][j - 1] && board[i][j] == board[i][j - 1]) {
//                        chainFlag = true;
//                            visited[i][j - 1]  = true;
//                        if(status[i][j] > status[i][j - 1]){
//                            status[i][j - 1] = status[i][j]+1;
//                        }
//                    }
//                    if (status[i][j - 1] > MaxChineCnt) {
//                        MaxChineCnt = status[i][j - 1] ;
//                        chainFlag = true;
//                    }
//                }
//                if (i < N - 1) {
//                    if (!visited[i + 1][j] && board[i][j] == board[i + 1][j]) {
//                        chainFlag = true;
//                            visited[i + 1][j]  = true;
//                        if(status[i][j] > status[i + 1][j]){
//                            status[i + 1][j] = status[i][j]+1;
//                        }
//                    }
//                    if (status[i + 1][j] > MaxChineCnt) {
//                        MaxChineCnt = status[i + 1][j];
//                        chainFlag = true;
//                    }
//                }
//                if (j < M - 1) {
//                    if (!visited[i][j + 1] && board[i][j] == board[i][j + 1]) {
//                        chainFlag = true;
//                            visited[i][j + 1]  = true;
//                        if(status[i][j] > status[i][j + 1]){
//                            status[i][j + 1] = status[i][j]+1;
//                        }
//                    }
//                    if (status[i][j + 1] > MaxChineCnt) {
//                        MaxChineCnt = status[i][j+1];
//                        chainFlag = true;
//                    }
//                }
//                if (chainFlag) {
//                    status[i][j] = MaxChineCnt+ 1;
////                    status[i][j] = MaxChineCnt> 1|| MaxChineCnt ==0?  MaxChineCnt+ 1: MaxChineCnt;
//                }
//                if(visited[i][j]) continue;
//                if(dfs(-1, -1, i, j)){
//                    System.out.println("Yes");
//                    System.exit(0);
//                }
            }
        }
        return answer;
    }

    public void dfs(boolean[][] visited, int[][] board, int[][] status, int i, int j, int li, int lj) {
        if (i > 0 && !(i - 1 == li && j == lj) && !visited[i - 1][j] && board[i][j] == board[i - 1][j]) {
            status[i][j] = status[i - 1][j] + 1;
            visited[i - 1][j] = true;
            dfs(visited, board, status, i - 1, j, i, j);
        } else if (j > 0 && !(i == li && j - 1 == lj) && !visited[i][j - 1] && board[i][j] == board[i][j - 1]) {
            status[i][j] = status[i][j - 1] + 1;
            visited[i][j - 1] = true;
            dfs(visited, board, status, i, j - 1, i, j);
        } else if (i < board[0].length - 1 && !(i + 1 == li && j == lj) && !visited[i + 1][j] && board[i][j] == board[i + 1][j]) {
            status[i][j] = status[i + 1][j] + 1;
            visited[i + 1][j] = true;
            dfs(visited, board, status, i + 1, j, i, j);
        } else if (j < board.length - 1 && !(i == li && j+1 == lj) && !visited[i][j + 1] && board[i][j] == board[i][j + 1]) {
            status[i][j] = status[i][j + 1] + 1;
            visited[i][j + 1] = true;
            dfs(visited, board, status, i, j + 1, i, j);
        }
    }

}

