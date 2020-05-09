package com.james.leetcode.hash;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 */
public class TopKFrequent {

    /**
     * 首先统计每个数字出现的个数O(n)
     * 对 MAP进行排序，获得topK的可以
     */
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if(nums == null) return null;
            int[] results = new int[k];
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                Integer count = map.get(num);
                if(count == null) count = 0;
                map.put(num, count+1);
            }
            List<Integer> res = new ArrayList<>();
            map.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .forEachOrdered(b->res.add(b.getKey()));
            for (int i = 0; i < k; i++) {
                results[i] = res.get(i);
            }
            return  results;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,2,2};
        print(new TopKFrequent.Solution().topKFrequent(nums, 1));

        int[] nums2 = {1,1,1,1,2,2,2,3,3,3,3,3,4,4,4,4,5,5,5,5,5,5,5,5};
        print(new TopKFrequent.Solution().topKFrequent(nums2, 5));
    }

    public static void print(int[] results){
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] +",");
        }
        System.out.println();
    }
}
