package com.james.leetcode.array;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * 输入的数组只包含 0 和 1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 */
public class MaxConsecutiveOnes {

    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            if(nums == null) return 0;
            int sumNum = 0;
            int maxNum = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 1){
                    sumNum++;
                }else if(nums[i] == 0 && sumNum > 0){
                    if(sumNum > maxNum) maxNum = sumNum;
                    sumNum = 0;
                }
            }
            if(sumNum > maxNum) maxNum = sumNum;
            return maxNum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int[] nums1 = {0,1,1,0,1,1,1};
        int[] nums2 = {1,1,0,1,1,1,0 };
        int[] nums3 = {1,1,0,0,1,1,1};
        int[] nums4 = {1,1};
        int[] nums5 = {1,0,0,0,0,0};
        int[] nums6 = {0,0,0,0,0,0,0,1};
        int[] nums7 = {1};
        int[] nums8 = {0};
        int[] nums9 = {1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1};
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums) == 3);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums1) == 3);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums2) == 3);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums3) == 3);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums4) == 2);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums5) == 1);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums6) == 1);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums7) == 1);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums8) == 0);
        System.out.println(new MaxConsecutiveOnes.Solution().findMaxConsecutiveOnes(nums9) == 9);
    }
}
