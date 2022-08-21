package pers.jssd.myleetcode.general;

/**
 * @author root
 */
public class Main1455 {

    public static void main(String[] args) {
        String ss = "i love eating burger";
        String sw = "burg";
        ss = "this problem is an easy problem";
        sw = "pro";
        ss = "i am tired";
        sw = "you";
        Solution solution = new Solution();
        int prefixOfWord = solution.isPrefixOfWord(ss, sw);
        System.out.println("prefixOfWord = " + prefixOfWord);
    }

    private static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int res = -1;

            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                boolean flag = false;
                for (int j = 0; j < searchWord.length(); j++) {
                    char sc = searchWord.charAt(j);
                    if (j >= word.length()) {
                        flag = true;
                        break;
                    }
                    char c = word.charAt(j);
                    if (sc != c) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    res = i + 1;
                    break;
                }
            }

            return res;
        }
    }
}
