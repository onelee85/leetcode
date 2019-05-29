package com.james.leetcode.string;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null) return "";
            if(strs.length == 1) return strs[0];
            if(strs.length < 2) return "";
            String prefixStr = getPrefix(strs[0], strs[1]);
            for (int i = 2; i < strs.length; i++) {
                prefixStr = getPrefix(prefixStr, strs[i]);
            }
            return prefixStr;
        }

        //获取2个字符串的公共前缀
        private String getPrefix(String str1, String str2){
            if(str1 == null || str2 == null) return "";
            StringBuilder prefix = new StringBuilder();
            int len1 = str1.length();
            int len2 = str2.length();
            int len = len1 > len2 ? len2 : len1;
            for (int i = 0; i < len; i++) {
                if(str1.charAt(i) == str2.charAt(i)){
                    prefix.append(str1.charAt(i));
                }else{
                    break;
                }
            }
            return prefix.toString();
        }
    }

    static class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null) return "";
            int strsLen = strs.length;
            if(strsLen == 1) return strs[0];
            if(strsLen < 2) return "";
            //找到最小的长度
            int minLen = strs[0].length();
            for (String str : strs){
                if(str.length() < minLen) minLen = str.length();
            }
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < minLen; i++) {
                Character c = null;
                for (String str : strs){
                    if(c == null){
                        c = str.charAt(i);
                    }
                    if(str.charAt(i) != c) {
                        c = null;
                        break;
                    }
                }
                if(c != null){
                    prefix.append(c);
                }else{
                    return prefix.toString();
                }
            }
            return prefix.toString();
        }
    }

    static class Solution3 {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null) return "";
            int strsLen = strs.length;
            if(strsLen == 1) return strs[0];
            if(strsLen < 2) return "";

            for (int i = 0; i < strs[0].length(); i++){
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if(i == strs[j].length() || strs[j].charAt(i) != c){
                        return strs[0].substring(0, i);
                    }
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","floight"};
        String[] strs2 = {"aca","cba"};
        System.out.println(new LongestCommonPrefix.Solution().longestCommonPrefix(strs));
        System.out.println(new LongestCommonPrefix.Solution2().longestCommonPrefix(strs));
        System.out.println(new LongestCommonPrefix.Solution3().longestCommonPrefix(strs));
    }
}
