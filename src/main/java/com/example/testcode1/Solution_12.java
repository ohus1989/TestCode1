package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_12 {
    public static void main(String[] args) throws IOException {
        String str = "abcd";
//        String str = "zabzczxa";
//        String str = "abcz";
        System.out.println(solution(str));
    }

    public static int solution(String s) {
        if (s.length() == 0) return 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    if (list.isEmpty() || list.get(list.size() - 1) == 'z') {
                        list.add('a');
                    }
                    break;
                case 'z':
                    if (list.isEmpty() || list.get(list.size() - 1) == 'a') {
                        list.add('z');
                    }
                    break;
            }
        }
        return list.size() > 1 ? list.size() - 1 : 0;
    }
}

