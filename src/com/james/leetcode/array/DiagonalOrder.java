package com.james.leetcode.array;

/**
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 示例:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000 。
 */

public class DiagonalOrder {
    static class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if(matrix == null) return null;
            if(matrix.length == 1) return matrix[0];
            if(matrix.length == 0) return new int[]{};
            int[] arrs = new int[matrix.length * matrix[0].length];
            int index = 0;
            goRight(matrix, arrs, index, 0, 0);
            return arrs;
        }

        public void goRight(int[][] matrix, int[] arrs, int index, int i, int k){
            while (i >= 0 && k < matrix[i].length){
                arrs[index++] = matrix[i][k];
                i--;k++;
            }
            //朝右移动  如果到底
            i++;
            if(i >= matrix.length) return;
            if(k >= matrix[i].length){
                //朝下移动
                k--;
                if(i++ >= matrix.length){
                    return;
                }
            }
            //放入左对角线
            goLeft(matrix, arrs, index, i, k);
        }

        public void goLeft(int[][] matrix, int[] arrs, int index, int i, int k){
            while (i < matrix.length && k >= 0){
                arrs[index++] = matrix[i][k];
                i++;k--;
            }
            //朝下移动 如果到底
            k++;
            if(i >= matrix.length){
                //往右移动
                i--;
                if(k++ >= matrix[i].length){
                    return;
                }
            }
            //放入右对角线
            goRight(matrix, arrs, index, i, k);
        }
    }

    public static void main(String[] args) {
        test1(new DiagonalOrder.Solution());
    }

    private static void test1(Solution s){

        int[][] matrix0 = {};
        printArrs(s.findDiagonalOrder(matrix0));

        int[][] matrix = {  {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printArrs(s.findDiagonalOrder(matrix));

        int[][] matrix1 = {  {1, 2, 3, 7, 8},
                            {4, 5, 6, 9, 10}
        };
        printArrs(s.findDiagonalOrder(matrix1));


        int[][] matrix2 = {  {1, 2},
                            {4, 5}
        };
        printArrs(s.findDiagonalOrder(matrix2));

        int[][] matrix3 = {  {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        printArrs(s.findDiagonalOrder(matrix3));
        int[][] matrix4 = {  {1, 2},
                {4, 5},
                {7, 8}
        };
        printArrs(s.findDiagonalOrder(matrix4));

        int[][] matrix5 = {  {1, 2, 3, 4}
        };
        printArrs(s.findDiagonalOrder(matrix5));

        int[][] matrix6 = {
                {1},
                {2},
                {3},
                {4}
        };
        printArrs(s.findDiagonalOrder(matrix6));

        //[[1,2,3,4,5,6,7,8,9,10],[11,12,13,14,15,16,17,18,19,20]]
        //预期: [1,2,11,12,3,4,13,14,5,6,15,16,7,8,17,18,9,10,19,20]
        int[][] matrix7 = {  {1,2,3,4,5,6,7,8,9,10},
                            {11,12,13,14,15,16,17,18,19,20}
        };
        printArrs(s.findDiagonalOrder(matrix7));
    }

    static void printArrs(int [] result){
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
        System.out.println("");
    }

}
