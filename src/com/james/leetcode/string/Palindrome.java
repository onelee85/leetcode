package com.james.leetcode.string;

/**
 * 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Palindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            if(s == null) return Boolean.FALSE;
            if(s.length() == 0 || s.length() == 1) return Boolean.TRUE;
            if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return Boolean.TRUE;
            char[] cs = s.toCharArray();
            int[] letterNums = new int[cs.length];
            int index = 0;
            //删选出合法的(字母和数字字符)字符
            for (char c : cs){
                if(c >= '0' && c <= '9') letterNums[index++] = c;
                else if(c >= 'a' && c <= 'z') letterNums[index++] = c;
                else if(c >= 'A' && c <= 'Z') {//大写字母转化为小写
                    letterNums[index++] = ('a'-'A') + c;
                }
            }
            //从顶端和尾端开始比较，如果不相等则不是回文字符串
            for (int i = 0, j = index - 1; i < index/2 && i != j; i++,j--) {
                if(letterNums[i] != letterNums[j]) return  Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = "abab";
        System.out.println(new Palindrome.Solution().isPalindrome(str1));
        System.out.println(new Palindrome.Solution().isPalindrome(str2));
        System.out.println(new Palindrome.Solution().isPalindrome(str3));
    }
}
