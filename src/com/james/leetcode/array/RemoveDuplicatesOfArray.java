package com.james.leetcode.array;

/**
 * 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesOfArray {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) return nums.length;
            int i = 0;
            int j = 1;
            int k = j;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    nums[k] = nums[j];
                    i++;
                    k++;
                }
                j++;
            }
            return k;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = new RemoveDuplicatesOfArray.Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
