package pers.jssd.myleetcode.general;

import java.util.Arrays;

/**
 * @author root
 */
public class Main1422 {

    public static void main(String[] args) {
//        String s = "011101";
        String s = "01001";
        Solution solution = new Solution();
        int i = solution.maxScore(s);
        System.out.println("i = " + i);
    }


    private static class Solution {
        public int maxScore(String s) {
            if (s.equals("00") || s.equals("11")) {
                return 1;
            }
            if (s.equals("01")) {
                return 2;
            }
            if (s.equals("10")) {
                return 0;
            }
            int max = 0;
            char[] arr = s.toCharArray();
            for (int i = 1; i < s.length() - 1; i++) {
                int res = 0;
                for (int j = 0; j < i; j++) {
                    if (arr[j] == '0') {
                        res ++;
                    }
                }
                for (int j = i; j < s.length(); j++) {
                    if (arr[j] == '1') {
                        res ++;
                    }
                }
                max = Math.max(res, max);
            }
            return max;
        }
    }

}
