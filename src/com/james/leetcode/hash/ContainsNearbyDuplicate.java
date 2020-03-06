package com.james.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums == null || nums.length <= 1) return false;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if(map.containsKey(n)){
                    int index = map.get(n);
                    int dis = i - index;
                    if(dis <= k ) return true;
                    else map.put(n, i);
                }else{
                    map.put(n, i);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(new Solution().containsNearbyDuplicate(nums, k));
    }
}
