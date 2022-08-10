package com.example.testcode1.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_36 {
    public static void main(String[] args) throws IOException {
        // case 1
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        System.out.println(solution(S, C));
    }

    public static String solution(String names, String C) {

        String[] nameArr = names.split(",");

        List<String> nameList = new ArrayList<>();

        for (String string : nameArr) {
            if (" ".equals(string.substring(0, 1))) {
                string = string.substring(1, string.length());
            }
            nameList.add(string);
        }

        List<String> emailList = new ArrayList<>();
        List<String> fNameInit = new ArrayList<>();
        List<String> nameInit = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {

            String[] tmpArr = nameList.get(i).split(" ");

            // 마지막 자리가 성 (소문자로 변경)
            String fname = tmpArr[tmpArr.length - 1].toLowerCase().replaceAll("-", "");
            if (fname.length() > 8) {
                fname = fname.substring(0, 8);
            }

            fNameInit.add(fname);

            String name = "";

            for (int j = 0; j < tmpArr.length-1; j++) {
                name += tmpArr[j].substring(0, 1).toLowerCase();
            }

            nameInit.add(name);

            emailList.add(name + fname);
        }
        System.out.println(emailList);


        for (int i = 0; i < emailList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (emailList.get(i).equals(emailList.get(j))) {
                    emailList.set(i, emailList.get(i) + "_");
                }
            }
        }

        for (int i = 0; i < emailList.size(); i++) {
            String str = emailList.get(i);
            if (str.contains("_")) {
                int count = 1;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == ('_')) {
                        count++;
                    }
                }
                emailList.set(i, str.replaceAll("_", "")+count);
            }
        }
        return "";
    }
}

