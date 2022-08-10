package com.example.testcode1.jewon;

import java.io.IOException;

class Solution_27 {
    public static void main(String[] args) throws IOException {
        //case 1
//        String penter = "1100";
//        String pexit = "0010";
//        String pescape = "1001";
//        String data = "1101100100101111001111000000";

//        case 2
        String[] strArgs = {"2", "1", "2", "-1", "3"};
        String w = "2";
        solution(strArgs, w);
    }

    public static void solution(String[] strArgs, String w) {

        int parseW = Integer.parseInt(w);
        for (int i = 0; i < strArgs.length; i++) {
            long maxNum = -99999;
            if (i + parseW <= strArgs.length) {
                for (int j = 0; j < parseW; j++) {
                    long compareNum = Long.parseLong(strArgs[i + j]);
                    if (compareNum > maxNum) {
                        maxNum = compareNum;
                    }
                }
                System.out.println(maxNum);
            }

        }
    }

}

