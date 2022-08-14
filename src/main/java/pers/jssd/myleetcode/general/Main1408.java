package pers.jssd.myleetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @author root
 */
public class Main1408 {

    public static void main(String[] args) {
//        String[] words = new String[]{"mass", "as", "hero", "superhero"};
//        String[] words = new String[]{"leetcode","et","code"};
        String[] words = new String[]{"blue", "green", "bu"};
        Solution solution = new Solution();
        List<String> strings = solution.stringMatching(words);
        System.out.println("strings = " + strings);
    }

    private static class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].length() == words[j].length()) {
                        continue;
                    }
                    if (words[i].length() < words[j].length() && words[j].contains(words[i])) {
                        if (!result.contains(words[i])) {
                            result.add(words[i]);
                        }
                    } else if (words[i].length() > words[j].length() && words[i].contains(words[j])) {
                        if (!result.contains(words[j])) {
                            result.add(words[j]);
                        }
                    }
                }
            }
            return result;
        }
    }

    ;
}
