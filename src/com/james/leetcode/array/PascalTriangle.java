package com.james.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class PascalTriangle {

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<Integer> rows = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            if(numRows <= 0) return result;
            rows.add(1);
            result.add(rows);
            for (int i = 1; i < numRows; i++) {
                List<Integer> newRows = new ArrayList<>();
                newRows.add(1);
                for (int j = 0; j < rows.size()-1; j++) {
                    newRows.add(rows.get(j) + rows.get(j+1));
                }
                newRows.add(1);
                result.add(newRows);
                rows = newRows;

            }
            return result;
        }
    }

    public static void main(String[] args) {
        printAll(new PascalTriangle.Solution().generate(100)) ;
    }

    private static void printAll(List<List<Integer>> result){
        result.forEach( list -> {
            list.forEach(item -> System.out.print(item+","));
            System.out.println("");
        });
    }
}
