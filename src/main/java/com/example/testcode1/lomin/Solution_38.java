package com.example.testcode1.lomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution_38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        int[][] matrix = new int[N][N];
        for(int i =0; i< N ;i++){
            String inputN = br.readLine();
            String[] splitLine = inputN.split(" ");
            for(int j = 0; j < splitLine.length;j++){
                matrix[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        String twoDat = br.readLine();
        int x = Integer.parseInt(twoDat.split(" ")[0]);
        int y = Integer.parseInt(twoDat.split(" ")[1]);
        int result = 0;
        if(x <= 0 || y <= 0 || x > N || y > N ){
            System.out.println(result);
        }else{
            for(int i = x -2; i <= x; i++ ){
                if(i < 0 || i >= N ){
                    continue;
                }
                for(int j = y -2; j <= y; j++ ){
                    if(j >= 0 && j < N ){
                        result += matrix[i][j];
                    }
                }
            }
        }
        System.out.println(result);
    }

}

