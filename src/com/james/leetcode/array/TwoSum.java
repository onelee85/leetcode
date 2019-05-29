package com.james.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    /**
     * 暴力循环
     */
    static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return result;
        }
    }

    /**
     * 使用map记录每个数字的位置
     */
    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                numbers.put(nums[i], i);
            }
            //循环获取
            for (int i = 0; i < nums.length; i++) {
                Integer elem = target - nums[i];
                if (numbers.containsKey(elem) && numbers.get(elem) != i) {
                    return new int[]{i, numbers.get(elem)};
                }
            }
            return result;
        }
    }

    static class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            Map<Integer, Integer> needNumbers = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                Integer elem = target - nums[i];//获取此元素的差值
                if (needNumbers.containsKey(elem)) {//判断当前集合内是否有符合条件的数字
                    return new int[]{needNumbers.get(elem), i};
                }
                needNumbers.put(nums[i], i);//记录好数字的位置
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 12, 5};
        int target = 7;
        int[] result = new Solution1().twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
        int[] result2 = new Solution2().twoSum(nums, target);
        System.out.println(result2[0] + "," + result2[1]);
        int[] result3 = new Solution3().twoSum(nums, target);
        System.out.println(result3[0] + "," + result3[1]);
    }
}
