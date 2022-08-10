package com.example.testcode1;

import java.io.IOException;
import java.util.*;

class Solution_11 {
    public static void main(String[] args) throws IOException {
        String[] movie = {"spy", "ray", "spy", "room", "once", "ray", "spy", "once"};
        System.out.println(Arrays.toString(solution(movie)));
    }

    public static String[] solution(String[] movie) {
        Set<String> temp = new HashSet<String>(Arrays.asList(movie));
        String[] tempStrArr = temp.toArray(new String[temp.size()]);
        String[] result = new String[tempStrArr.length];
        List<Map<String, Object>> itemSet = new ArrayList<>();
        for (int i = 0; i < tempStrArr.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("key", tempStrArr[i]);
            item.put("f", Collections.frequency(Arrays.asList(movie), tempStrArr[i]));
            itemSet.add(item);
        }

        Collections.sort(itemSet, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                int f1 = Integer.parseInt(o1.get("f").toString());
                int f2 = Integer.parseInt(o2.get("f").toString());
                if (f1 > f2) {
                    return -1;
                } else if (f1 < f2) {
                    return 1;
                } else {
                    return o1.get("key").toString().compareTo(o2.get("key").toString());
                }
            }
        });

        for (int i = 0; i < itemSet.size(); i++) {
            result[i] = itemSet.get(i).get("key").toString();
        }
        return result;
    }
}

