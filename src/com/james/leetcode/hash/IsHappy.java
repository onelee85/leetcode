package com.james.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {

    static class Solution {
        public boolean isHappy(int n) {
            if(n == 1) return true;
            Set<Integer> set = new HashSet<>();
            while (true){
                int sum = sum (n);
                if(sum == 1) return true;
                if(!set.add(sum)){
                    return false;
                }
                n = sum;
            }
        }

        public int sum(int n ){
            int sum = 0;
            while(n != 0) {
                int k = n % 10;
                sum += k*k;
                n = n / 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        IsHappy.Solution s = new IsHappy.Solution();
        System.out.println(s.isHappy(19));
        System.out.println(s.sum(82)==68);
        System.out.println(s.sum(111)==3);
        System.out.println(s.sum(10));
        System.out.println(s.sum(100));
        System.out.println(s.sum(1000));
        System.out.println(s.sum(1));
        System.out.println(s.sum(22));
        System.out.println(s.sum(222));
    }
}
