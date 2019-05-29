package com.james.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {

    /**
     * 1.循环将字符串保存到MAP里，只出现过一次的为0，超过一次的为1
     * 2.遍历字符串，返回第一个为0的字符
     */
    static class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;
            if (s.length() == 1) return 0;
            char[] cs = s.toCharArray();
            //循环数据
            Map<Character, Integer> chars = new HashMap<Character, Integer>();
            for (int i = 0; i < cs.length; i++) {
                if (chars.containsKey(cs[i])) {
                    chars.put(cs[i], 1);
                } else {
                    chars.put(cs[i], 0);
                }
            }
            for (int i = 0; i < cs.length; i++) {
                Integer count = chars.get(cs[i]);
                if (count == 0) {
                    return i;
                }

            }
            return -1;
        }
    }

    /**
     * O(N^2)
     */
    static class Solution2 {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;
            if (s.length() == 1) return 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (s.indexOf(c) == s.lastIndexOf(c))
                    return i;
            }
            return -1;
        }
    }

    /**
     * 核心思想：利用char ASCII码  a - z  空间利用：26个字母的数组占位
     * 当字母出现过，则当前位置加1。
     */
    static class Solution3 {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) return -1;
            if (s.length() == 1) return 0;
            char[] cs = s.toCharArray();
            char[] letters = new char[26]; //出现的字母次数
            for (int i = 0; i < cs.length; i++) {
                letters['z' - cs[i]]++;
            }
            for (int i = 0; i < cs.length; i++) {//如果
                if(letters['z' - cs[i]] == 1) return i;
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(new FirstUniqChar.Solution().firstUniqChar(str));
        System.out.println(new FirstUniqChar.Solution2().firstUniqChar(str));
        System.out.println(new FirstUniqChar.Solution3().firstUniqChar(str));
    }
}
