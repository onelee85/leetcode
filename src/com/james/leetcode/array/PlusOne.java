package com.james.leetcode.array;

import java.util.Arrays;

/**
 * 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 示例 3:
 * 输入: [9,9]
 * 输出: [1,0,0]
 * 解释: 输入数组表示数字 100。
 */
public class PlusOne {

    static class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                int num = digits[i];
                if (num + 1 < 10) { //判断是否需要进位
                    digits[i] = num + 1; //如果不需要，则直接加一返回结果
                    return digits;
                } else {
                    digits[i] = 0; //需要进位
                }
            }
            //数组最后一位需要进位，扩容一个新数组
            int[] result = new int[digits.length + 1];
            Arrays.fill(result, 0);//全部填充为0
            result[0] = 1;//首位为1
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 9};
        int[] resut = new PlusOne.Solution().plusOne(nums);
        for (int num : resut) {
            System.out.print(num + ",");
        }
    }
}
