package com.james.leetcode.array;

import java.util.Arrays;

/**
 * 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 提示:
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 */
public class ArrayPairSum {

    /**
     * 组合问题 n个数中选m个数的组合
     * C=n!/m!*(n - m)!
     * O(nlogn+n)
     *
     * 如果这类配对产生的总损失最小化，那么总金额现在将达到最大值。
     * 只有当为配对选择的数字比数组的其他元素更接近彼此时，才有可能将每个配对中的损失最小化。
     * 考虑到这一点，我们可以对给定数组的元素进行排序，并直接按排序顺序形成元素的配对。
     * 这将导致元素的配对，它们之间的差异最小，从而导致所需总和的最大化。
     *
     */
    static class Solution {
        public int arrayPairSum(int[] nums) {
            int result = 0;
            if(nums == null || nums.length % 2 != 0 || nums.length < 2) return result;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i+=2) {
                result += nums[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {1,4,3,2};
        int [] nums2 = {2,2,1,2,1,1};
        int [] nums3 = {3,2,5,2,1,1,2,2,5,6};
        int [] nums4 = {100,158,1000,2000, 10000,20000};
        int [] nums5 = {7,1,2,4,6,3,1,1,2,4,6,8,6,3};
        System.out.println(new ArrayPairSum.Solution().arrayPairSum(nums1)==4);
        System.out.println(new ArrayPairSum.Solution().arrayPairSum(nums2)==4);
        System.out.println(new ArrayPairSum.Solution().arrayPairSum(nums3)==13);
        System.out.println(new ArrayPairSum.Solution().arrayPairSum(nums4)==11100);
        System.out.println(new ArrayPairSum.Solution().arrayPairSum(nums5)==24);
    }
}
