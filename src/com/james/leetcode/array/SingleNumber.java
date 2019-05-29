package com.james.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    static class Solution1 {

        public int singleNumber(int[] nums) {
            Set<Integer> numbers = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (numbers.contains(num)) {
                    numbers.remove(num);
                } else {
                    numbers.add(num);
                }
            }
            return numbers.iterator().next();
        }
    }

    //所有的数都异或，相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身。
    //异或 : 参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0
    static class Solution2 {
        public int singleNumber(int[] nums) {
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                num ^= nums[i];
            }
            return num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int index = new SingleNumber.Solution1().singleNumber(nums);
        int index2 = new SingleNumber.Solution2().singleNumber(nums);
        System.out.println(index);
        System.out.println(index2);
        System.out.println(4 ^ 2);
    }
}
