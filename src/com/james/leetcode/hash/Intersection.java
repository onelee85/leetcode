package com.james.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {

    static class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> nums = new HashSet<>();

            for (int n : nums1){
                set.add(n);
            }
            for (int n : nums2){
                if(set.contains(n))
                    nums.add(n);
            }
            int[] res = new int[nums.size()];
            int i = 0;
            for (Integer n : nums){
                res[i++] = n;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {1,1,2,2,3};
        printAll(new Intersection.Solution().intersection(nums1, nums2));
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        printAll(new Intersection.Solution().intersection(nums3, nums4));
    }

    private static void printAll(int[] arrs){
        for (int i = 0; i < arrs.length ; i++) {
            System.out.print(arrs[i]+",");
        }
        System.out.println();
    }
}
