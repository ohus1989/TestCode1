package com.example.testcode1.jewon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Solution_28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        List<Long> array = new LinkedList<>();
        while (br.ready()) {
            if (array.size() < w) {
                array.add(Long.parseLong(br.readLine()));
            } else {
                array.remove(0);
                array.add(Long.parseLong(br.readLine()));
            }
            if (array.size() >= w) {
                Long max = array.stream().mapToLong(value
                        -> value).max().orElseThrow();
                System.out.println(max);
            }
        }
    }
}

