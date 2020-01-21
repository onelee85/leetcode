package com.james.leetcode.string;

import java.util.StringTokenizer;

/**
 * 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWords {

    static class Solution {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            StringTokenizer st = new StringTokenizer(s, " ");
            while (st.hasMoreElements()){
                String word = st.nextElement().toString().trim();
                result.insert(0, word + " ");
            }
            return result.toString().trim();
        }
    }

    static class Solution2 {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            String[] words = s.trim().split(" ");
            for (int i = words.length - 1; i >= 0 ; i--) {
                String word = words[i];
                if(word.length() >= 1){
                    result.append(word).append(" ");
                }
            }
            return result.toString().trim();
        }
    }

    public static void main(String[] args) {
        ReverseWords.Solution2 solution = new ReverseWords.Solution2();
        System.out.println(solution.reverseWords("the sky is blue").equals("blue is sky the"));
        System.out.println(solution.reverseWords("  hello world!  ").equals("world! hello"));
        System.out.println(solution.reverseWords("a good   example").equals("example good a"));
        System.out.println(solution.reverseWords("     a     good   example  ").equals("example good a"));
        System.out.println(solution.reverseWords("a b c da ").equals("da c b a"));
    }
}
