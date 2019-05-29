package com.james.leetcode.string;

/**
 * +
 * <p>
 * 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseNumber {

    static class Solution {
        //不断模10取得最低位，再不断乘10相加得到最终的反转结果
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                //取模10获取最低位数 123 % 10 = 3
                int tmp = res * 10 + x % 10;
                x = x / 10; //获取前几位 123/10 = 12
                //溢出判断 如果发生溢出了结果必然不相等 例如 tmp=321,  321/10 == 32 res = 32
                if (tmp / 10 != res) {
                    return 0;
                }
                res = tmp;
            }
            return res;
        }
    }


    public static void main(String[] args) {
        int num = 1111111112;
        System.out.println(new ReverseNumber.Solution().reverse(num));
    }
}
