package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_9 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] logs = new String[n];
        List<Map<String, Object>> sort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            logs[i] = scanner.nextLine().trim();
            if(!sort.isEmpty()){
                Map<String, Object> item = sort.get(sort.size()-1);
                if (item.get("key").equals(logs[i])) {
                    item.put("cnt", Integer.parseInt(item.get("cnt").toString()) +1);
                }else{
                    Map<String, Object> addItem = new HashMap<>();
                    addItem.put("key", logs[i]);
                    addItem.put("cnt", 1);
                    sort.add(addItem);
                }
            }else{
                Map<String, Object> addItem = new HashMap<>();
                addItem.put("key", logs[i]);
                addItem.put("cnt", 1);
                sort.add(addItem);
            }


        }
        System.out.println(sort.size());
        for (Map<String, Object> item : sort) {
            String addStr = "";
            if (Integer.parseInt(item.get("cnt").toString()) > 1) {
                addStr = " (" + Integer.parseInt(item.get("cnt").toString()) + ")";
            }
            System.out.println(item.get("key") + addStr);
        }

    }


}

