package com.james.leetcode.array;

/**
 * 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateMatrix {
    static class Solution {
        public void rotate(int[][] matrix) {
            //左上角
            int tl = 0;
            int dl = 0;
            //右下角
            int tr = matrix.length - 1;
            int dr = matrix[0].length - 1;
            while (tl < tr) {//先旋转最外圈, 再逐步往里圈内走
                roate(matrix, tl++, dl++, tr--, dr--);
            }
        }

        public void roate(int[][] matrix, int tl, int dl, int tr, int dr) {
            int times = tr - tl;
            for (int i = 0; i < times; i++) {
                int tmp = matrix[tl + i][dr];
                matrix[tl + i][dr] = matrix[tl][dl + i];
                matrix[tl][dl + i] = matrix[tr - i][dl];
                matrix[tr - i][dl] = matrix[tr][dr - i];
                matrix[tr][dr - i] = tmp;
            }
        }
    }

    static class Solution1 {
        public void rotate(int[][] matrix) {
            int row = matrix.length;
            int num = row / 2;
            for (int i = 0; i < num; i++) {//先交换最外圈的
                for (int m = i; m < row - i - 1; m++) {//外圈交换元素
                    int temp = matrix[i][m];
                    matrix[i][m] = matrix[row - 1 - m][i];
                    matrix[row - 1 - m][i] = matrix[row - i - 1][row - 1 - m];
                    matrix[row - i - 1][row - 1 - m] = matrix[m][row - i - 1];
                    matrix[m][row - i - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

       /* int[][] nums = {{5, 1, 9,11},
                        {2, 4, 8,10},
                        {13, 3, 6, 7},
                        {15,14,12,16}
                        };*/
        //new RotateMatrix.Solution().rotate(nums);
        new RotateMatrix.Solution1().rotate(nums);
        for (int[] num2s : nums) {
            for (int num : num2s) {
                System.out.print(num + ",");
            }
            System.out.println("");
        }
    }
}
