package com.example.testcode1.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution_34 {
    public static void main(String[] args) throws IOException {
        // case 1
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        System.out.println(solution(S, C));
    }

    public static String solution(String S, String C) {
        String[] splitName = S.split(", ");

        List<String> nameArray = new ArrayList<>();
        String lowerCaseCompanyName = C.toLowerCase();
        StringBuilder resultSb = new StringBuilder();
        for (String name : splitName) {
            String[] splitNameDtl = name.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Character.toLowerCase(splitNameDtl[0].charAt(0)));
            if (splitNameDtl.length != 2) {
                stringBuilder.append(Character.toLowerCase(splitNameDtl[1].charAt(0)));
            }
            String tempStr = splitNameDtl[splitNameDtl.length - 1].replace("-", "");
            stringBuilder.append(tempStr.substring(0, tempStr.length() < 8 ? tempStr.length() : 8).toLowerCase());
            boolean addArray = false;
            int sameIndex = 1;
            String tempEmailName = "";
            while (!addArray) {
                tempEmailName = sameIndex > 1 ? stringBuilder.toString() + sameIndex : stringBuilder.toString();
                if (!nameArray.contains(tempEmailName)) {
                    nameArray.add(tempEmailName);
                    addArray = true;
                } else {
                    sameIndex++;
                }
            }

            resultSb.append(name);
            resultSb.append(" <");
            resultSb.append(tempEmailName + "@" + lowerCaseCompanyName + ".com>, ");
        }
        return resultSb.substring(0, resultSb.toString().length() - 2);
    }

}

