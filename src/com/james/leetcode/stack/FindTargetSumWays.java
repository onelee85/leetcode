package com.james.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * 注意:
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 */
public class FindTargetSumWays {

    /**
     *          0
     *      -1      1
     *    -1   1  -1   1
     *  加法和减法, 二叉树思路考虑, 递归模式深度优先搜索
     */
    static class Solution {

        private Integer count = 0;
        public int findTargetSumWays(int[] nums, int S) {
            count = 0;
            if(nums == null || nums.length == 0) return 0;
            int sum = 0;
            int i = 0;
            sum(nums, i, sum, S);
            return count;
        }

        private void sum(int[] nums, int i, int sum, int target){
            if(i == nums.length){
                if(sum == target){
                    count++;
                }
                return;
            }
            sum(nums, i+1, sum+nums[i], target);//加法+
            sum(nums, i+1, sum-nums[i], target);//减法-
        }
    }


    static class Solution2 {

        public int findTargetSumWays(int[] nums, int S) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1 ) return (nums[0] == S || -nums[0] == S) ? 1 : 0;

            Stack<Integer> stack = new Stack<>();
            stack.push(nums[0]);
            stack.push(-nums[0]);
            for (int i = 1; i < nums.length; i++) {
                Stack<Integer> res = new Stack<>();
                while (!stack.empty()){
                    int n = stack.pop();
                    res.push(n - nums[i]);
                    res.push(n + nums[i]);
                }
                stack = res;
            }
            int count = 0;
            for (Integer n : stack){
                if(n == S){
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {45,18,27,39,42,19,1,35,32,16,7,6,25,41,27,18,38,6,42,10};
        int s = 49;
        System.out.println(new FindTargetSumWays.Solution().findTargetSumWays(nums, s));
        System.out.println(new FindTargetSumWays.Solution2().findTargetSumWays(nums, s));

        int[] nums2 = new int[20];
        Arrays.fill(nums2, 1);
        s = 5;
        long startTime=System.currentTimeMillis();
        System.out.println(new FindTargetSumWays.Solution().findTargetSumWays(nums2, s));
        System.out.println("Solution3 运行时间： "+(System.currentTimeMillis()-startTime)+"ms");
    }

}
