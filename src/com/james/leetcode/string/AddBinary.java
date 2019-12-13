package com.james.leetcode.string;


/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    static class Solution {
        public String addBinary(String a, String b) {
            if(a == null || b == null || a.equals("")  || b.equals("")) return null;
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            String str = "";
            int aIndex = aChars.length - 1, bIndex = bChars.length - 1;
            int move = 0;
            while (aIndex >= 0 || bIndex >= 0){
                int an = aIndex >=0 ? aChars[aIndex--] - '0' : 0;
                int bn = bIndex >=0 ? bChars[bIndex--] - '0' : 0;
                int sum = an + bn + move;
                if(sum == 2){
                    sum = 0;
                    move = 1;
                }else if(sum == 3){
                    sum = 1;
                    move = 1;
                }else{
                    move = 0;
                }
                str = sum + str;
            }
            if(move == 1){
                str = 1 + str;
            }
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary.Solution().addBinary("11", "1").equals("100"));
        System.out.println(new AddBinary.Solution().addBinary("1010", "1011").equals("10101"));
        System.out.println(new AddBinary.Solution().addBinary("0", "0").equals("0"));
        System.out.println(new AddBinary.Solution().addBinary("1", "0").equals("1"));
        System.out.println(new AddBinary.Solution().addBinary("111111", "1").equals("1000000"));
        System.out.println(new AddBinary.Solution().addBinary("1111", "1111").equals("11110"));
        System.out.println(new AddBinary.Solution().addBinary("",""));
    }
}
