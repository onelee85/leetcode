package com.james.leetcode.array;

/**
 * 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class RotateArray {

    static class Solution1 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            for (int i = 0; i < k; i++) { //移动K次数组
                int tmp = nums[length - 1];
                for (int j = length - 1; j >= 1; j--) { //将数组中的元素向右移动
                    nums[j] = nums[j - 1];
                }
                nums[0] = tmp;
            }
        }
    }

    static class Solution2 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            for (int i = 0; i < k; i++) { //翻转K次数组
                for (int j = length - 1; j >= 1; j--) { //将数组中的元素向右交换
                    swap(nums, j, j - 1);
                }
            }

        }

        public void swap(int[] num, int i, int j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }

    /**
     * 暂时没看懂
     */
    static class Solution3 {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            int count = 0;
            for (int start = 0; count < nums.length; start++) {
                int current = start;
                int prev = nums[start];

                do {
                    int next = (current + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                } while (start != current);
            }

        }

    }

    /**
     * 1,2,3,4  K=2
     * 翻转整数组:   4,3,2,1
     * 翻转前部分:   3,4,2,1
     * 翻转后部分:   3,4,1,2
     */
    static class Solution4 {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1); //先翻转整个数组
            reverse(nums, 0, k - 1); //翻转前部分
            reverse(nums, k, nums.length - 1);//翻转后部分
        }

        public void reverse(int[] nums, int right, int left) {
            while (right < left) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right++;
                left--;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;
        System.out.println(k % nums.length);
        //new RotateArray.Solution1().rotate(nums, k);
        //new RotateArray.Solution2().rotate(nums, k);
        //new RotateArray.Solution3().rotate(nums, k);
        new RotateArray.Solution4().rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}
