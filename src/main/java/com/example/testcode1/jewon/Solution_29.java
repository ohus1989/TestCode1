package com.example.testcode1.jewon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_29 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        while (stk.hasMoreTokens()){
            int m = Integer.parseInt(stk.nextToken());
        }
        int m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int answer = 0;
        while (true) {
            if (sum >= m) {
                sum -= arr[l++];
            } else if (r == n) break;
            else if (sum < m) {
                sum += arr[r++];
            }
            if (sum == m) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}

