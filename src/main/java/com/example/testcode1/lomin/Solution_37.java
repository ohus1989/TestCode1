package com.example.testcode1.lomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution_37 {
    public static void main(String[] args) throws IOException {
        int[] monthPay = {29900, 34900, 39900, 49900, 59900, 69900};
        int[] monthData = {300, 1000, 2000, 6000, 11000};
        int CAL_DATA = 20;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        int targetPay = Integer.parseInt(input1.split(" ")[0]);
        int targetData = Integer.parseInt(input1.split(" ")[1]);

        int rPay = 0;
        int pMPay = 0;
        int pPay = 0;
        if(targetData < 300){
            rPay = monthPay[0];
        }
        for (int i = 0; i < monthPay.length; i++) {
            if (monthPay[i] == targetPay) {
                pMPay += monthPay[i];
                if (i != 5) {
                    int useData = targetData - monthData[i];
                    if (useData > 0 && useData < 5000) {
                        pMPay += (useData * CAL_DATA) > 25000 ? 25000 : (useData * CAL_DATA);
                    }else if (useData >= 5000){
                        pMPay += (useData * CAL_DATA) > 180000 ? 180000 : (useData * CAL_DATA);
                    }
                }
            }
            if (i != 0 && i != 5) {
                if (monthData[i - 1] < targetData && monthData[i] >= targetData) {
                    rPay = monthPay[i];
                    pPay = monthPay[i];
                }
            }
        }
        if(rPay == 0){
            rPay = monthPay[5];
        }
        System.out.println(rPay +" "+ pMPay +" "+ pPay);
    }

}

