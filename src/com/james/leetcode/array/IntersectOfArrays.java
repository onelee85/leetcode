package com.james.leetcode.array;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectOfArrays {

    static class Solution1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] minNums = null;
            int[] maxNums = null;
            Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
            //选出小的数组 和大的数组
            if (nums1.length < nums2.length) {
                minNums = nums1;
                maxNums = nums2;
            } else {
                minNums = nums2;
                maxNums = nums1;
            }

            //循环大的数组 将元素存入MAP能并且记录出现的次数
            for (int i = 0; i < maxNums.length; i++) {
                Integer count = nums.get(maxNums[i]);
                if (count == null)
                    count = 0;
                nums.put(maxNums[i], ++count);
            }
            //初始化交集数组
            int[] temps = new int[minNums.length];
            int j = 0;
            //循环的小的数据，判断如果再另外一个大数组里出现过的，则记录到交集数组里
            for (int i = 0; i < minNums.length; i++) {
                Integer count = nums.get(minNums[i]);
                if (count != null && count > 0) {
                    nums.put(minNums[i], --count);
                    temps[j++] = minNums[i];
                }

            }
            int[] results = new int[j];
            for (int i = 0; i < j; i++) {
                results[i] = temps[i];
            }
            return results;
        }
    }

    static class Solution2 {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0)
                return new int[0];
            //先对两个数组进行进行排序
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> list = new ArrayList<Integer>();
            //分别移动两个数组的索引，如果相同则为交集元素
            for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
                if (nums1[i] < nums2[j]) i++;
                else if (nums1[i] > nums2[j]) j++;
                else {
                    list.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int[] results = new int[list.size()];
            int i = 0;
            for (Integer o : list) {
                results[i++] = o;
            }

            return results;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {1, 2};
        int[] res = new IntersectOfArrays.Solution1().intersect(nums1, nums2);
        int[] res2 = new IntersectOfArrays.Solution2().intersect(nums1, nums2);
        for (int num : res) {
            System.out.print(num + ",");
        }
        System.out.println();
        for (int num : res2) {
            System.out.print(num + ",");
        }
    }
}
