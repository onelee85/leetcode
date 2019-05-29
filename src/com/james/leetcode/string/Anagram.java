package com.james.leetcode.string;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Anagram {

    static class Solution {
        /**
         * 异位词：2个字符串长度相等, 2个字符串内字母相同
         */
        public boolean isAnagram(String s, String t) {
            if(s == null || t == null) return  Boolean.FALSE;
            if(s.length() != t.length()) return Boolean.FALSE;
            char[] cs1 = s.toCharArray();
            char[] cs2 = t.toCharArray();
            //对两个字符串char数组排序
            Arrays.sort(cs1);
            Arrays.sort(cs2);
            //比较字母是否相同
            for (int i = 0; i < cs1.length; i++) {
                if(cs1[i] != cs2[i]) return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    static class Solution2 {
        /**
         * 假设字符串只包含小写字母
         */
        public boolean isAnagram(String s, String t) {
            if(s == null || t == null) return  Boolean.FALSE;
            if(s.length() != t.length()) return Boolean.FALSE;
            char[] cs1 = s.toCharArray();
            char[] cs2 = t.toCharArray();
            int[] letters = new int[26];
            //分别对字母加减，如果是相同的字母则会相互抵消。计数数组则为0
            for (int i = 0; i < cs1.length; i++) {
                letters[cs1[i] - 'a']++;
                letters[cs2[i] - 'a']--;
            }
            for (int c : letters) {
                if(c != 0) return  Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        System.out.println(new Anagram.Solution().isAnagram(str1, str2));
        System.out.println(new Anagram.Solution2().isAnagram(str1, str2));
    }
}
