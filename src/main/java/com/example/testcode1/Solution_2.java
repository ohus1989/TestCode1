package com.example.testcode1;

import java.util.Arrays;
import java.util.Collections;

public class Solution_2 {
    public static long solution(int N) {
        long result;
        String tempNumber = "" + N;
        String[] ary = tempNumber.split("");
        String[] sortedArrAsc = ary.clone();
        String[] sortedArrDesc = ary.clone();
        Arrays.sort(sortedArrAsc);
        Arrays.sort(sortedArrDesc, Collections.reverseOrder());
        StringBuilder sbfAsc = new StringBuilder("");
        StringBuilder sbfDesc = new StringBuilder("");
        for (String value : sortedArrAsc) {
            sbfAsc.append(value);
        }
        for (String value : sortedArrDesc) {
            sbfDesc.append(value);
        }
        result = Long.parseLong(sbfAsc.toString()) + Long.parseLong(sbfDesc.toString());
        return result;
    }
}
