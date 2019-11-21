package com.james.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9, 10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if(matrix == null || matrix.length == 0) return result;
            int [][] visited = new int[matrix.length][matrix[0].length];
            spiralOrder(matrix, 0, 0, result, visited);
            return result;
        }

        /**
         * 顺时钟方向：先向右，向下，向左，向上 知道遍历重复的元素
         *
         */
        public void spiralOrder(int[][] matrix, int x, int y, List<Integer> result , int [][] visited){
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length){
                if(visited[x][y] == 0){
                    visited[x][y] = 1;
                    result.add(matrix[x][y]);
                    spiralOrder(matrix, x, y+1, result, visited);//向右
                    spiralOrder(matrix, x+1, y, result, visited);//向下
                    spiralOrder(matrix, x, y-1, result, visited);//向左
                    up(matrix, x-1, y, result, visited);//向上
                }
            }
        }

        public void up(int[][] matrix, int x, int y, List<Integer> result , int [][] visited){
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length){
                if(visited[x][y] == 0){
                    visited[x][y] = 1;
                    result.add(matrix[x][y]);
                    up(matrix, x-1, y, result, visited);//向上
                }
            }
            spiralOrder(matrix, x, y+1, result, visited);//向右
        }

    }

    static class Solution2 {
        /**
         * 1.顺时钟方向：先向右，向下，向左，向上 遍历所有元素 M*N
         * 2.下一个要到达的元素超出边界或者已经访问过的元素时，
         * 3.下一个到达元素位置为当前元素 继续遍历
         *
         * 顺时钟旋转技巧 m=[0, 1, 0, -1] n=[1, 0, -1, 0]
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if(matrix == null || matrix.length == 0) return result;
            boolean [][] visited = new boolean[matrix.length][matrix[0].length];
            //遍历的元素
            int count = matrix.length * matrix[0].length;
            int n=0,m=0;//起点坐标
            int di=0;//前进的坐标
            //前进方向
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            for (int i = 0; i < count; i++) {
                result.add(matrix[n][m]);
                visited[n][m] = true;
                //下一个要到达的元素的坐标
                int next_n = n + dr[di];
                int next_m = m + dc[di];
                if(next_n >= 0 && next_m >= 0 && next_n < matrix.length
                        && next_m< matrix[n].length && !visited[next_n][next_m]){
                    n = next_n;
                    m = next_m;
                }else{
                    di = (di+1) % 4;//顺时钟旋转技巧
                    n += dr[di];
                    m += dc[di];
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        //test1(new SpiralOrder.Solution());
        test1(new SpiralOrder.Solution2());
    }

    private static void test1(SpiralOrder.Solution2 s) {

        int[][] matrix0 = {};
        printArrs(s.spiralOrder(matrix0));

        int[][] matrix = {  {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        printArrs(s.spiralOrder(matrix));

        int[][] matrix1 = {  {1, 2, 3, 4, 5},
                {10, 9, 8, 7,6}
        };
        printArrs(s.spiralOrder(matrix1));


        int[][] matrix2 = {  {1, 2},
                {4, 3}
        };
        printArrs(s.spiralOrder(matrix2));

        int[][] matrix3 = {  {1, 2, 3, 4},
                            {12, 13, 14, 5},
                            {11, 16, 15, 6},
                            {10, 9, 8, 7},
        };
        printArrs(s.spiralOrder(matrix3));

        int[][] matrix4 = {  {1, 2},
                {6, 3},
                {5, 4}
        };
        printArrs(s.spiralOrder(matrix4));

        int[][] matrix5 = {  {1, 2, 3, 5}
        };
        printArrs(s.spiralOrder(matrix5));

        int[][] matrix6 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        printArrs(s.spiralOrder(matrix6));

        int[][] matrix7 = {  {1,2,3,4,5,6,7,8,9,10},
                {20,19,18,17,16,15,14,13,12,11}
        };
        printArrs(s.spiralOrder(matrix7));

        int[][] matrix8 = {  {1,1},
                             {2,2}
                          };
        printArrs(s.spiralOrder(matrix8));

        int[][] matrix9 = {  {1,2,3},
                {16,17,4},
                {15,19,5},
                {14,20,6},
                {13,21,7},
                {12,22,8},
                {11,10,9}
        };
        printArrs(s.spiralOrder(matrix9));


        int[][] matrix10 = { {1,2,3,4,5,6},
                            {16,17,18,19,20,7},
                            {15,24,23,22,21,8},
                            {14,13,12,11,10,9}
        };
        printArrs(s.spiralOrder(matrix10));
    }

    static void printArrs(List<Integer> result){
        result.forEach(it -> System.out.print(it+","));
        System.out.println("");
    }
}
