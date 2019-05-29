package com.james.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class DuplicateNumOfArrays {

    /**
     * 通过set的集合，如果有重复则返回
     */
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> deplications = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (!deplications.add(nums[i])) return true;
            }
            return false;
        }
    }

    /**
     * 先进行排序， 如果前一个元素等会后一个元素则有重复
     */
    static class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            if (nums.length < 2) return false;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Boolean resut = new DuplicateNumOfArrays.Solution().containsDuplicate(nums);
        Boolean resut2 = new DuplicateNumOfArrays.Solution2().containsDuplicate(nums);
        System.out.println(resut);
        System.out.println(resut2);
    }
}
