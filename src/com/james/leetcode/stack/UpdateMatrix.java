package com.james.leetcode.stack;

/**
 * 01 矩阵
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 注意:
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class UpdateMatrix {

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] results = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int[][] visited = new int[matrix.length][matrix[0].length];
                    results[i][j] = dfs(matrix, visited, i, j, 0);
                }
            }
            return results;
        }

        private int dfs(int[][] matrix, int[][] visited, int x, int y, int dis){
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length){
                return -1;
            }

            if(visited[x][y] == 1 || matrix[x][y] == 0)
                return dis;

            visited[x][y] = 1;

            int up = dfs(matrix, visited,x-1, y,dis+1);
            int down = dfs(matrix, visited, x+1, y,dis+1);
            int left = dfs(matrix, visited, x, y-1,dis+1);
            int right = dfs(matrix, visited, x, y+1,dis+1);

            int distance = -1;
            if(up > 0){
                distance = up;
            }if(down > 0){
                distance = down < distance ? down : distance;
            }if(left > 0){
                distance = left < distance ? left : distance;
            }if(right > 0){
                distance = right < distance ? right : distance;
            }
            return distance;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {  {0, 0, 0},
                            {1, 1, 0},
                            {1, 1, 1}
        };
        int[][] newMatrix = new UpdateMatrix.Solution().updateMatrix(matrix);

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j]+", ");
            }
            System.out.println();
        }
    }
}
