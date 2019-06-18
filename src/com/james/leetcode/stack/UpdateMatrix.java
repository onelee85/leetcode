package com.james.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

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

    @Deprecated
    static class Solution {

        @Deprecated
        public int[][] updateMatrix(int[][] matrix) {
            int[][] results = new int[matrix.length][matrix[0].length];
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    int[][] visited = new int[matrix.length][matrix[x].length];
                    results[x][y] = dfs(matrix, visited, x, y, 0);
                }
            }
            return results;
        }

        public int dfs(int[][] matrix, int[][] visited, int x, int y, int dis){
            //如果为边界放弃探索
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length){
                return -1;
            }
            if(visited[x][y] == 1)
                return -1;

            if(matrix[x][y] == 0)
                return dis;

            visited[x][y] = 1;

            int up = dfs(matrix, visited,x-1, y,dis+1);
            int down = dfs(matrix, visited, x+1, y,dis+1);
            int left = dfs(matrix, visited, x, y-1,dis+1);
            int right = dfs(matrix, visited, x, y+1,dis+1);

            int distance = -1;
            distance = calculateMinDis(distance, up);
            distance = calculateMinDis(distance, down);
            distance = calculateMinDis(distance, left);
            distance = calculateMinDis(distance, right);
            return distance;
        }

        public int calculateMinDis(int min, int dis){
            if(min < 0 && dis >= 0){
                min = dis;
            }
            else if (min >= 0 && dis >= 0 && dis < min){
                min = dis;
            }
            return min;
        }
    }


    /**
     * 通过0节点开始分层
     * 广度优先搜索
     *  1.初始化，将值为0的放在队列中，不为0的则初始化为最大值
     *  2.只要新的间距比原来的小，更新并加入队列中（因为设置了最小的，就会影响周围的）
     */
    static class Solution2 {

        public int[][] updateMatrix(int[][] matrix) {
            int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int row = matrix.length;
            int col = matrix[0].length;
            Queue<int[]> queue = new LinkedList<>();

            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if(matrix[x][y] == 0)//记录为0的节点
                        queue.add(new int[]{x ,y});
                    else
                        matrix[x][y] = row + col; //初始化会最大距离值
                }
            }

            while (!queue.isEmpty()){
                int[] s = queue.poll();
                //上下左右四个方向
                for (int[] v : vector){
                    int r = s[0] + v[0];
                    int c = s[1] + v[1];
                    if(r >= 0 && r < row &&
                            c >= 0 && c < col &&
                                matrix[r][c] > matrix[s[0]][s[1]] + 1){ //如果当前距离值大于到0节点的
                        matrix[r][c] = matrix[s[0]][s[1]] + 1;
                        queue.add(new int[] {r, c});
                    }
                }
            }

            return matrix;
        }

    }

    public static void main(String[] args) {

        int[][] matrix = {  {1, 1, 1},
                            {1, 1, 1},
                            {1, 1, 0}
        };

        //int[][] visited = new int[matrix.length][matrix[2].length];
        //System.out.println(new UpdateMatrix.Solution().dfs(matrix, visited, 2, 2, 0));

        //int[][] newMatrix = new UpdateMatrix.Solution().updateMatrix(matrix);
        int[][] newMatrix = new UpdateMatrix.Solution2().updateMatrix(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j]+", ");
            }
            System.out.println();
        }
    }
}
