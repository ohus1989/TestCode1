package com.example.testcode1.jewon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        Long[] arrayLong = new Long[w + 1];
        int index = 0;
        boolean initFlag = false;
        while (br.ready()) {
            if (index == w + 1) {
                index = 0;
            }
            if (index == w) {
                if (!initFlag) {
                    initFlag = true;
                }
            }
            try {
                arrayLong[index] = Long.parseLong(br.readLine());
            }catch (Exception e){
                arrayLong[index] = Long.valueOf(0);
            }
            index++;

            if (initFlag) {
                System.out.println(Arrays.stream(arrayLong).mapToLong(value -> value).max().orElseThrow());
            }
        }
    }
}

