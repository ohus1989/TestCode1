package com.example.testcode1.jewon;

import java.util.TimeZone;
import java.util.Calendar;

class Solution_31 {
    public static void main(String[] args) {
//        long currentTimestamp = Long.parseUnsignedLong("1605163143000");
//        long postTimestamp = Long.parseUnsignedLong("1605163133000");
//        long currentTimestamp = Long.parseUnsignedLong("1605153160000");
//        long postTimestamp = Long.parseUnsignedLong("1605144160000");
//        long currentTimestamp = Long.parseUnsignedLong("1605164160000");
//        long postTimestamp = Long.parseUnsignedLong("1605064160000");
//        long currentTimestamp = Long.parseUnsignedLong("1605164160000");
//        long postTimestamp = Long.parseUnsignedLong("1604064160000");
        long currentTimestamp = Long.parseUnsignedLong("1659080311000");
        long postTimestamp = Long.parseUnsignedLong("1659080011000");
//        long currentTimestamp = Long.parseUnsignedLong("1605164160000");
//        long postTimestamp = Long.parseUnsignedLong("1504064160000");
        System.out.println(solution(currentTimestamp, postTimestamp));
    }

    public static String solution( long currentTimestamp, long postTimestamp) {
        String answer = "";

        int threeMin = 180; //초
        int oneMin = 60; //초
        int oneHour = 3600; //3600초
        int oneDay = 86400;
        int oneMonth = 2592000;
        int oneYear = 31104000;

        long min = currentTimestamp - postTimestamp;
        long second =  min / 1000;

        if (0 <= second && second < threeMin) {
            answer = "Now";
        } else if(second < oneHour) {
            answer = second / oneMin + " minutes ago";
        } else if(second < oneDay) {
            answer = second / oneHour + " hours ago";
        } else if(second < oneMonth) {
            answer = second / oneDay + " days ago";
        } else if(second < oneYear) {
            answer = second / oneMonth + " months ago";
        } else if(oneYear <= second){
            answer = second / oneYear + " years ago";
        }

        //날짜 확인 해야된다.
        TimeZone gmt = TimeZone.getTimeZone ("GMT");
        Calendar currCal = Calendar.getInstance (gmt);
        Calendar postCal = Calendar.getInstance (gmt);
        currCal.setTimeInMillis(currentTimestamp);
        postCal.setTimeInMillis(postTimestamp);

        if(currCal.get(Calendar.DATE) == postCal.get(Calendar.DATE) + 1 ){
            answer = "Yesterday";
        } else if(currCal.get(Calendar.MONTH) == postCal.get(Calendar.MONTH) + 1 ){
            answer = "Last month";
        } else if(currCal.get(Calendar.YEAR) == postCal.get(Calendar.YEAR) + 1){
            answer = "Last year";
        }
        return answer;
    }
}

