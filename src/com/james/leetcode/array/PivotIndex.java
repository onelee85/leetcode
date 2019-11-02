package com.james.leetcode.array;

/**
 * 寻找数组的中心索引
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1:
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 示例 2:
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 * 说明:
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 *
 * [-1,-1,-1,0,1,1]
 * 预期结果
 * 0
 *
 * [-1,-1,-1,0,1,1]
 *  * 预期结果
 *  * 0
 */
public class PivotIndex {

    static class Solution {
        public int pivotIndex(int[] nums) {
            if(nums == null || nums.length == 0) return -1;
            int length = nums.length;
            //先计算出来左侧和右侧的累加和
            int r = 0, l = 0;
            for (int i = 1; i < length ; i++) {
                l += nums[i];
            }
            for (int index = 0; index < length; index++) {
                if(r == l) return index;
                r += nums[index];
                if(index < length -1)
                    l -= nums[index+1];
                else
                    l = 0;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,-1,-1,0,1,1};
        int[] nums2 = {1, 7, 3, 6, 5, 6};
        int[] nums3 = {-1, 2, 3};
        int[] nums4 = {1, -1, -1};
        System.out.println(new PivotIndex.Solution().pivotIndex(nums1));
        System.out.println(new PivotIndex.Solution().pivotIndex(nums2));
        System.out.println(new PivotIndex.Solution().pivotIndex(nums3));
        System.out.println(new PivotIndex.Solution().pivotIndex(nums4));
    }
}
