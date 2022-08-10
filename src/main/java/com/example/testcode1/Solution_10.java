package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_10 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] logs = new String[n];
        List<String> result = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            logs[i] = scanner.nextLine().trim();
            if(result.isEmpty()){
                result.add(logs[i]);
            }else{
                if(!result.get(result.size() -1).equals(logs[i]) || i == n -1){
                    String addStr = "";
                    if(cnt > 1){
                        addStr = " ("+cnt+")";
                    }
                    result.add(logs[i] + addStr);
                    cnt = 1;
                } else{
                    cnt++;
                }
            }
        }
        System.out.println(result.size());
        for(String item : result){
            System.out.println(item);
        }

    }




}

