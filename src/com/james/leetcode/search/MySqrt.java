package com.james.leetcode.search;

/**
 * x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    static class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x, result = -1;
            while (left <= right){
                int mid = left + (right -left) / 2;
                if((long)mid * mid <= x){
                    result = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt.Solution().mySqrt(4));
        System.out.println(new MySqrt.Solution().mySqrt(8));
        System.out.println(new MySqrt.Solution().mySqrt(9));
        System.out.println(new MySqrt.Solution().mySqrt(16));
        System.out.println(new MySqrt.Solution().mySqrt(255));
        System.out.println(new MySqrt.Solution().mySqrt(2147395599));
    }
}
