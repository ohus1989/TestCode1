package com.example.testcode1;

import java.io.IOException;

class Solution_5 {
    public static void main(String[] args) throws IOException {
        Solution_5 solution = new Solution_5();
        long n = 12;
        long[] answer = solution.solution(n);
        System.out.println();
    }

    public long[] solution(long n) {
        long[] answer = {-1, -1};
        long divide = 2;
        long another = -1;
        while (true) {
            if (n % divide > 0) {
                divide++;
            } else if (divide > n / 2) {
                break;
            } else {
                long divide2 = 2;
                another = n / divide;
                Boolean flag = false;
                while (true) {
                    if (another % divide2 > 0) {
                        divide2++;
                    } else if (divide2 > another / 2) {
                        break;
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    answer = new long[]{divide, another};
                }
                break;
            }
        }
        return answer;
    }

}

