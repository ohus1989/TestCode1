package com.example.testcode1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_13 {
    public static void main(String[] args) throws IOException {
        int[] str = {6, 2, 3, 4, 1, 5};
//        int[] str = {5,3,4,6,2,1};
        System.out.println(solution(str));
    }

    public static int solution(int[] stats) {
        List<Map<String, Integer>> itemSet = new ArrayList<>();
        for (int item : stats) {
            if (itemSet.isEmpty()) {
                Map<String, Integer> itemMap = new HashMap<>();
                itemMap.put("high", item);
                itemMap.put("low", item);
                itemSet.add(itemMap);
            } else {
                Boolean addItem = false;
                for (Map<String, Integer> itemMap : itemSet) {
                    if (itemMap.get("high") < item) {
                        itemMap.put("high", item);
                        addItem = true;
                        break;
                    }
                }
                if (!addItem) {
                    Map<String, Integer> itemMap = new HashMap<>();
                    itemMap.put("high", item);
                    itemMap.put("low", item);
                    itemSet.add(itemMap);
                }
            }
        }
        return itemSet.size();
    }
}

