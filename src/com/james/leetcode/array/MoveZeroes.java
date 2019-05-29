package com.james.leetcode.array;

/**
 * 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    static class Solution {
        public void moveZeroes(int[] nums) {
            //计算有多少个零 （非必须）
            int countZero = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) countZero++;
            }
            //如果无非零元素则直接返回
            if (countZero == 0) return;
            int moveCount = 0;
            for (int i = 0; i < nums.length; i++) {
                //找到非零元素， 将非零元素往前移动
                if (nums[i] != 0) {
                    nums[moveCount++] = nums[i];
                }
            }
            //设置移动完后的非零元素的位置为零
            for (int i = moveCount; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1};
        new MoveZeroes.Solution().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
