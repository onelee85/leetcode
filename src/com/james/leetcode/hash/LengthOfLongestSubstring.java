package com.james.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    /**
     * 暴力解法
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null)return 0;
            if(s.length() == 1) return 1;
            int maxLength = 0;
            Set<Character> charSet = new HashSet<>();
            char[] chars = s.toCharArray();
            int i = 0, j = i;
            for (; i < chars.length && chars.length > maxLength; i++) {
                for (j = i; j < chars.length; j++) {
                    char c = chars[j];
                    if(!charSet.add(c)){
                        maxLength = Math.max(maxLength, j-i);
                        charSet.removeAll(charSet);
                        break;
                    }
                }
            }
            maxLength = Math.max(maxLength, j-i);
            return maxLength;
        }
    }

    /**
     * 滑动窗口
     * begin  end
     * [a,b,c,d,b,c,a,d]
     *  ↑--4--↑
     *  ↑       ↑
     *      ↑--3--↑
     *       ↑      ↑
     */
    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if(s == null)return 0;
            if(s.length() == 1) return 1;
            int maxLength = 0;
            Map<Character, Integer> charSet = new HashMap<>();
            char[] chars = s.toCharArray();
            int length = chars.length;
            int beginIndex = 0,endIndex = 0;
            for (; endIndex < length && maxLength < length && beginIndex < length; endIndex++) {
                char c = chars[endIndex];
                Integer existIndex = charSet.get(c);
                if(existIndex != null && existIndex >= beginIndex){
                    maxLength = Math.max(maxLength, endIndex - beginIndex);
                    beginIndex = existIndex + 1;
                }
                charSet.put(c, endIndex);
            }
            maxLength = Math.max(maxLength, endIndex - beginIndex);
            return maxLength;
        }
    }

    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            if(s == null)return 0;
            if(s.length() == 1) return 1;
            int maxLength = 0;
            int head = 0,tail = 0;
            for (; tail <  s.length(); tail++) {
                char c = s.charAt(tail);
                int index = s.indexOf(c, head);
                if(index < tail){
                    head = index + 1;
                }
                maxLength = Math.max(maxLength, tail - head + 1);
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring.Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring.Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring.Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring.Solution().lengthOfLongestSubstring("au"));
        System.out.println(new LengthOfLongestSubstring.Solution().lengthOfLongestSubstring("cd"));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(new LengthOfLongestSubstring.Solution2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring.Solution2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring.Solution2().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring.Solution2().lengthOfLongestSubstring("au"));
        System.out.println(new LengthOfLongestSubstring.Solution2().lengthOfLongestSubstring("cd"));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(new LengthOfLongestSubstring.Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring.Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring.Solution3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring.Solution3().lengthOfLongestSubstring("au"));
        System.out.println(new LengthOfLongestSubstring.Solution3().lengthOfLongestSubstring("cd"));


    }
}
