package com.james.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII {

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int [] result = new int[2];
            Map<Integer, Integer> elems = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                int ele = target - numbers[i];
                if(elems.containsKey(ele)){
                    return new int[]{elems.get(ele)+1, i+1};
                }
                elems.put(numbers[i], i);
            }
            return result;
        }
    }

    /**
     * 头尾双指针方法
     *
     */
    static class Solution2 {
        public int[] twoSum(int[] numbers, int target) {
            int i=0, k = numbers.length-1;
            while(i < k){
                int sum =  numbers[i] + numbers[k];
                if(target == sum)
                    return new int[]{i+1, k+1};
                else if(target > sum ){
                    i++;
                }else{
                    k--;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] result = new TwoSumII.Solution().twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
        int[] result2 = new TwoSumII.Solution2().twoSum(nums, target);
        System.out.println(result2[0] + "," + result2[1]);
    }
}
