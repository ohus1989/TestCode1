package com.example.testcode1.jewon;

import java.io.IOException;

class Solution_26 {
    public static void main(String[] args) throws IOException {
        //case 1
        String penter = "1100";
        String pexit = "0010";
        String pescape = "1001";
        String data = "1101100100101111001111000000";

//        case 2
//        String penter = "10";
//        String pexit = "11";
//        String pescape = "00";
//        String data = "00011011";
        System.out.println(solution(penter, pexit, pescape, data));
    }

    public static String solution(String penter, String pexit, String pescape, String data) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int penterLength = penter.length();
        int pexitLength = pexit.length();
        int pescapeLength = pescape.length();
        int dataLength = data.length();
        stringBuilder.append(penter);
        for (int i = 0; i < data.length() && index< data.length(); i++) {
            String compareStr = "";
            if(penterLength + index <= dataLength){
                compareStr = data.substring(index, penterLength + index);
                if (penter.equals(compareStr)) {
                    stringBuilder.append(pescape);
                    stringBuilder.append(compareStr);
                    index += penterLength;
                    continue;
                }
            }
            if(pexitLength + index <= dataLength){
                compareStr = data.substring(index, pexitLength + index);
                if (pexit.equals(compareStr)) {
                    stringBuilder.append(pescape);
                    stringBuilder.append(compareStr);
                    index += pexitLength;
                    continue;
                }
            }
            if(pescapeLength + index <= dataLength){
                compareStr = data.substring(index, pescapeLength + index);
                if (pescape.equals(compareStr)) {
                    stringBuilder.append(pescape);
                    stringBuilder.append(compareStr);
                    index += penterLength;
                    continue;
                }
            }

            stringBuilder.append(data, index, index+penterLength);
            index+=penterLength;
        }
        stringBuilder.append(pexit);

        return stringBuilder.toString();
    }

}

