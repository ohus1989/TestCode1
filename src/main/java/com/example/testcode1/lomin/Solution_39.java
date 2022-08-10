package com.example.testcode1.lomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution_39 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int x = Integer.parseInt(input.split(" ")[0]);
        int y = Integer.parseInt(input.split(" ")[1]);
        System.out.println(x >> y);
        System.out.println(x << y);
    }

}

