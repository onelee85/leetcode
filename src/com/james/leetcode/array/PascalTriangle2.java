package com.james.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalTriangle2 {

    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> rows = new ArrayList<>();
            rows.add(1);
            if(rowIndex == 0) return rows;
            for (int i = 1; i <= rowIndex; i++) {
                List<Integer> newRows = new ArrayList<>();
                newRows.add(1);
                for (int j = 0; j < rows.size()-1; j++) {
                    newRows.add(rows.get(j) + rows.get(j+1));
                }
                newRows.add(1);
                rows = newRows;

            }
            return rows;
        }
    }

    /**
     *  O(k) 空间复杂度
     */
    static class Solution1 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> rows = new ArrayList<>();
            rows.add(1);
            if(rowIndex == 0) return rows;
            int pre = 1;
            for (int i = 1; i <= rowIndex; i++) {
                for (int j = 1; j < i; j++) {
                    int tmp = rows.get(j);
                    rows.set(j, pre + rows.get(j));
                    pre = tmp;
                }
                rows.add(1);
            }
            return rows;
        }
    }

    public static void main(String[] args) {
        List<Integer> result = new PascalTriangle2.Solution1().getRow(33);
        result.forEach(it -> System.out.println(it + ","));
    }
}
