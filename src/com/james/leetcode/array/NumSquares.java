package com.james.leetcode.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class NumSquares {

    static class Solution {
        public int numSquares(int n) {
            if(n <= 0) return 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(0);
            int count = 0;
            while (!queue.isEmpty()){
                int qSize = queue.size();
                count++;
                while (qSize-- > 0) {
                    int curr = queue.remove();
                    int i = 1;
                    for (; curr + i * i < n ; i++) {
                        queue.add(curr + i * i);
                    }
                    if(curr + i * i == n) return count;
                }
            }
            return 0;
        }
    }

    /**
     *            0
     *     /      \      \
     *    1       4      9...n^2
     *   /\       /\     /\
     *  1...n^2  1..n^2  1..n^2
     */
    static class Solution2 {
        public int numSquares(int n) {
            if(n <= 0) return 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            Set<Integer> visited = new HashSet<Integer>();
            queue.add(0);
            int count = 0;//根节点- 启动用
            while (!queue.isEmpty()){
                int qSize = queue.size();
                count++;
                while (qSize-- > 0) {
                    int curr = queue.remove();
                    int i = 1;
                    int sum =0;
                    for (; sum <= n ; i++) { //遍历 1...n^2 个小于目标数n的平方数
                        sum = curr + i * i;
                        if(sum == n) return count;
                        if(!visited.contains(sum)){
                            queue.add(sum);
                            visited.add(sum);
                        }
                    }

                }
            }
            return 0;
        }
    }



    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        System.out.println(new NumSquares.Solution().numSquares(17168));
        System.out.println(new NumSquares.Solution().numSquares(7168));
        System.out.println(new NumSquares.Solution().numSquares(12333));
        System.out.println(new NumSquares.Solution().numSquares(10));
        System.out.println("Solution运行时间： "+(System.currentTimeMillis()-startTime)+"ms");

        startTime=System.currentTimeMillis();
        System.out.println(new NumSquares.Solution2().numSquares(17168));
        System.out.println(new NumSquares.Solution2().numSquares(7168));
        System.out.println(new NumSquares.Solution2().numSquares(12333));
        System.out.println(new NumSquares.Solution2().numSquares(10));
        System.out.println("Solution2运行时间： "+(System.currentTimeMillis()-startTime)+"ms");
    }
}
