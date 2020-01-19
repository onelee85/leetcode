package com.james.leetcode.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen {

    static class Solution {
        /**
         * 双指针模式 startIndex， endIndex
         * 累加双指针的和sum
         * 如果sum小于符合条件的值 则累加当前end指针的值并且end指针向前移动一位
         * 如果sum大于符合条件的值 则减去start指针的值并start指针向前移动动一位
         * 如果sum等于符合条件的值 则比较最小连续子数组的长度，记录最小长度。  start指针从end指针处开始
         * 时间复杂度 O(n^2)
         */
        public int minSubArrayLen(int s, int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return nums[0] == s ? 1 : 0;
            int startIndex = 0, endIndex = 0;
            int sum = nums[startIndex], minCount = 0;
            while (endIndex < nums.length) {
                sum = sum(nums, startIndex, endIndex);
                if(sum >= s){
                    int count = endIndex - startIndex + 1;
                    minCount = minCount == 0 ? count : Math.min(count, minCount);
                    startIndex++;
                    if(sum == s)
                        endIndex++;
                }else {
                    endIndex++;
                }
            }
            if(sum >= s){
                int count = endIndex - startIndex + 1;
                minCount = minCount == 0 ? count : Math.min(count, minCount);
            }
            return minCount;
        }

        public int sum(int[] nums, int start, int end){
            if(start >= nums.length || end >= nums.length) return -1;
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    /**
     * 双指针模式 index， leftIndex
     * index右移开始累加sum
     * 如果sum 大于等于 s, 符合条件 则缩小范围 leftIndex右移一位
     * 直到sum 小于 S  则index继续右移 累加sum
     */
    static class Solution1 {
        public int minSubArrayLen(int s, int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return nums[0] == s ? 1 : 0;
            int sum = 0, minCount = Integer.MAX_VALUE, leftIndex = 0;
            for (int index = 0; index < nums.length; index++) {
                sum += nums[index];
                while (sum >= s){
                    minCount = Math.min(minCount, index + 1 - leftIndex);
                    sum -= nums[leftIndex++];
                }
            }
            return minCount == Integer.MAX_VALUE ? 0 : minCount;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int[] nums1 = {1,1,1,3,1,1};
        int[] nums2 = {2,2};
        int[] nums3 = {8,23,4,111,23,5,6,123,66,11};
        int[] nums4 = {0};
        int[] nums5 = {1,2,3,4,5};
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(7, nums) == 2);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(5, nums) == 2);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(16, nums) == 0);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(15, nums) == 6);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(2, nums) == 1);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(2, nums1) == 1);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(3, nums2) == 2);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(11, nums3) == 1);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(0, nums4) == 1);
        System.out.println(new MinSubArrayLen.Solution1().minSubArrayLen(11, nums5) == 3);
    }
}
