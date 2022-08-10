package com.example.testcode1.socar;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution_42 {
    public static void main(String[] args) throws IOException {
        int n = 5;
        int k = 4;
        int[][] paths = {{1, 5, 1, 1}, {1, 2, 4, 3}, {1, 3, 3, 2}, {2, 5, 2, 1}, {2, 4, 2, 3}, {3, 4, 2, 2}};
        boolean[] visited;
        int depth = 0;
        System.out.println(solution(n, k, paths));
    }

    public static int solution(int n, int k, int[][] paths) {
        int answer = 0;
        return answer;
    }

    public static void dfs(int start, int end, boolean[] visited, int depth, int[][] paths){
        List<int[]> temp = Arrays.stream(paths).filter(item -> item[0] == start || item[1] == start).collect(Collectors.toList());
        long way = temp.size();

        for(int i = 0; i < way; i ++){
            int[] wayInfo = temp.get(i);
            int startNode, endNode;
            if(wayInfo[0] == start){
                startNode = wayInfo[0];
                endNode = wayInfo[1];
            }else{
                startNode = wayInfo[1];
                endNode = wayInfo[0];
            }
            if(!visited[endNode-1]){
                visited[endNode-1] = true;
                dfs(endNode, end, visited, depth, paths);
                visited[endNode-1] = false;
            }

        }
    }
}

