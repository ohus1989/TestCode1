package com.example.testcode1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution_8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(checkBracket(input));
    }

    private static String checkBracket(String s) {
        if (s.length() % 2 != 0) return "FALSE";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return Boolean.TRUE.equals(stack.empty())? "TRUE" : "FALSE";
    }

}

