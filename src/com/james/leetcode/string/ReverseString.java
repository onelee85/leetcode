package com.james.leetcode.string;

/**
 * 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class ReverseString {

    static class Solution {
        public void reverseString(char[] s) {
            if (s == null || s.length <= 1) return;
            for (int i = 0, j = s.length - 1; i < s.length && j > 0 && i < j; i++, j--) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
    }

    static class Solution2 {
        public void reverseString(char[] s) {
            if (s == null || s.length <= 1) return;
            int len = s.length;
            for (int i = 0; i < len / 2; i++) {
                char tmp = s[i];
                s[i] = s[len - i - 1];
                s[len - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        char[] chars2 = {'1', '2', '3', '4', '5', '6'};
        new ReverseString.Solution2().reverseString(chars2);
        System.out.print(new String(chars2) + ",");
    }
}
