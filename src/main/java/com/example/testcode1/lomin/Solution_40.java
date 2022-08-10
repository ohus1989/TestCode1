package com.example.testcode1.lomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution_40 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] layers = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            layers[i] = scanner.nextInt();
            if (i > 0) {
                answer += layers[i - 1] * layers[i];
            }
        }

        System.out.println(answer);
    }

}

