package com.james.leetcode.string;

/**
 * 实现strStr()
 * java: indexOf()
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 */
public class IndexOf {

    static class Solution {
        public int strStr(String haystack, String needle) {
            if(haystack == null || needle == null) return -1;
            if(needle.trim().length() == 0) return 0;
            if(needle.length() > haystack.length()) return -1;

            char[] cs1 = haystack.toCharArray();
            char[] cs2 = needle.toCharArray();

            //第一个字符串开始遍历
            for (int i = 0; i < cs1.length; i++) {

                int c_index = i;
                int count = 0 ;
                //第一个字符串剩余字符个数是否已经超出第二个字符串
                if(cs1.length-i < cs2.length) return -1;

                //第二个字符串逐个字符匹配是否全部相等
                for (int c2_index = 0 ; c2_index < cs2.length;) {
                    if(cs1[c_index++] != cs2[c2_index++]) break;
                    count++;
                }
                //相等的字符个数等于needle个数则返回i
                if(count == cs2.length) return i;
            }
            return -1;
        }
    }

    /**
     * 优化版，先找到一个字符
     */
    static class Solution2 {
        public int strStr(String haystack, String needle) {
            if(haystack == null || needle == null) return -1;
            if(needle.trim().length() == 0) return 0;
            if(needle.length() > haystack.length()) return -1;

            char[] cs1 = haystack.toCharArray();
            char[] cs2 = needle.toCharArray();
            //第一个字符
            char first = cs2[0];

            //第一个字符串开始遍历
            for (int i = 0; i < cs1.length; i++) {

                int c_index = i;
                //找到第一个匹配的字符的位置
                while (c_index <= cs1.length - cs2.length && cs1[c_index] != first){c_index++;}
                i = c_index;

                //第一个字符串剩余字符个数是否已经超出第二个字符串
                if((cs1.length-c_index) < cs2.length) return -1;

                int count = 0;
                //第二个字符串逐个字符匹配是否全部相等
                for (int c2_index = 0 ; c2_index < cs2.length;) {
                    if(cs1[c_index++] != cs2[c2_index++]) break;
                    count++;
                }
                //相等的字符个数等于needle个数则返回i
                if(count == cs2.length) return i;
            }
            return -1;
        }
    }

    /**
     * substring 账号
     */
    static class Solution3 {
        public int strStr(String haystack, String needle) {
            if(haystack == null || needle == null) return -1;
            int l1 = haystack.length();
            int l2 = needle.length();
            if(l2 == 0) return 0;//是空字符串时我们应当返回 0
            if(l2 > l1) return -1;//匹配的字符串超长

            for (int i = 0; i < l1 - l2 + 1; i++) {
                if(haystack.substring(i, i+l2).equals(needle))
                    return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "helloe";
        System.out.println(new IndexOf.Solution().strStr(haystack, needle));
        System.out.println(new IndexOf.Solution2().strStr(haystack, needle));
        System.out.println(new IndexOf.Solution3().strStr(haystack, needle));
    }
}
