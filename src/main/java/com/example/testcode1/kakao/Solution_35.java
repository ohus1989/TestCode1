package com.example.testcode1.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_35 {
    public static void main(String[] args) throws IOException {
        // case 1
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        System.out.println(solution(S, C));
    }

    public static String solution(String S, String C) {
        List<Person> list = new ArrayList<>();

        String[] nameSplit = S.split("\\,");
        Arrays.stream(nameSplit).forEach(name -> {
            String[] nameData = Arrays.stream(name.split(" ")).filter(e -> e.trim().length() > 0).toArray(String[]::new);
            if (nameData.length > 2) {
                list.add(new Person(nameData[0], nameData[1], nameData[2]));
            } else {
                list.add(new Person(nameData[0], nameData[1], ""));
            }
        });

        StringBuilder sb = new StringBuilder();

        List<String> duplicateList = new ArrayList<>();

        list.forEach(name->{
            sb.append(name.first);
            sb.append(" ");
            sb.append(name.second);
            if(!name.third.isEmpty()){
                sb.append(" ");
                sb.append(name.third);
            }

            String email = "";

            sb.append(" <");
            String first = String.valueOf(name.first.charAt(0)).toLowerCase();
            if(name.third.isEmpty()){
                String second ="";
                if(name.second.length() > 8)  second = name.second.replace("-","").substring(0,8).toLowerCase();
                else second = name.second.toLowerCase();
                email = first +second;
            }else{
                String second = String.valueOf(name.second.charAt(0)).toLowerCase();
                String third = "";
                if(name.third.length() > 8)  third = name.third.replace("-","").substring(0,8).toLowerCase();
                else third = name.third.toLowerCase();
                email = first+second+third;
            }
            if(duplicateList.contains(email)){
                String finalEmail = email;
                int listSize = duplicateList.stream().filter(duplicateName-> duplicateName.equals(finalEmail)).toArray().length + 1;
                duplicateList.add(email);
                sb.append(email).append(listSize);
            }else{
                duplicateList.add(email);
                sb.append(email);
            }
            sb.append("@");
            sb.append(C.toLowerCase()+".com");
            sb.append(">,");
            sb.append(" ");

        });
        return sb.substring(0,sb.length()-2);
    }

    static class Person {
        public String first;
        public String second;
        public String third;

        public Person(String first, String second, String third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}

