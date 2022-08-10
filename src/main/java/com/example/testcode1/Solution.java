package com.example.testcode1;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        int[] answer = solution.solution(id_list, report, k);
        System.out.println();
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        List<Map<String, Object>> resultStatus = new ArrayList();
        List<String> distinctReport = Arrays.stream(report).distinct().collect(Collectors.toList());
        for (String id : id_list) {
            Map<String, Object> status = new HashMap<>();

            status.put("id", id);
            List<String> benList = new ArrayList();
            int benCnt = 0;
            for (String item : distinctReport) {
                String[] splitStr = item.split(" ");
                if (splitStr[0].equals(id)) {
                    if(benList.contains(splitStr[1])){
                        break;
                    }
                    benList.add(splitStr[1]);
                }
                if (splitStr[1].equals(id)) {
                    benCnt++;
                }
            }
            status.put("benList", benList);
            status.put("benCnt", benCnt);
            resultStatus.add(status);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i ++){
            String id = id_list[i];
            int addReport = 0;
            for (Map<String, Object> status : resultStatus) {
                if (status.get("id").toString().equals(id)) {
                    for (String benId : (List<String>) status.get("benList")) {
                        for (Map<String, Object> status2 : resultStatus) {
                            if (status2.get("id").toString().equals(benId)) {
                                if ((int) status2.get("benCnt") >= k) {
                                    addReport++;
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = addReport;
        }


        return answer;
    }
}

