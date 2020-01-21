package com.james.leetcode.string;

/**
 * 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 *
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsIII {

    static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            String[] words = s.trim().split(" ");
            for (int i = 0; i < words.length ; i++) {
                String word = words[i];
                if(word.length() >= 1){
                    char[] chars = word.toCharArray();
                    reverseString(chars);
                    sb.append(new String(chars)).append(" ");
                }
            }
            return sb.toString().trim();
        }

        public void reverseString(char[] s) {
            int len = s.length;
            for (int i = 0; i < len / 2; i++) {
                char tmp = s[i];
                s[i] = s[len - i - 1];
                s[len - i - 1] = tmp;
            }
        }
    }

    static class Solution2 {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int length = s.length();
            int end = 0, begin = 0;
            while (end < length){
                end = s.indexOf(" ", begin);//end 为空格的index
                if(end < 0){ //最后一个单词，无空格了
                    end = length;
                }
                reverse(chars, begin, end - 1);//空格之前的单词翻转
                begin = end + 1; //从空格以后开始找下个单词
            }
            return new String(chars);
        }

        public void reverse(char[] s, int begin, int end) {
            while (begin < end){
                char tmp = s[begin];
                s[begin] =  s[end];
                s[end] = tmp;
                begin++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        ReverseWordsIII.Solution2 solution = new ReverseWordsIII.Solution2();
        System.out.println(solution.reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));
        System.out.println(solution.reverseWords("hello world!").equals("olleh !dlrow"));
        System.out.println(solution.reverseWords("a good example").equals("a doog elpmaxe"));
        System.out.println(solution.reverseWords("a b c da").equals("a b c ad"));
    }
}
