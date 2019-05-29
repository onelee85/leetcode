package com.james.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的个数
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class NumIslands {

    static class Solution {

        class Point{
            int x;
            int y;
            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int count = 0;

            Queue<Point> queue = new LinkedList<Point>();
            //是否访问过这个岛屿
            char[][] step = new char[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(step[i][j] == 1) continue;
                    if(grid[i][j] == '1'){
                        count++;
                        queue.add(new Point(i, j));
                    }
                    while(!queue.isEmpty()){
                        Point p = queue.remove();
                        int x = p.x;
                        int y = p.y;
                        if(step[x][y] == 1)
                            continue;
                        //访问这个岛屿的上下左右节点是否为岛屿
                        if(y+1 < grid[i].length && grid[x][y+1] == '1')
                            queue.offer(new Point(x, y+1));
                        if(x+1 < grid.length && grid[x+1][y] == '1')
                            queue.offer(new Point(x+1, y));
                        if(y-1 >= 0 && grid[x][y-1] == '1')
                            queue.offer(new Point(x, y-1));
                        if(x-1 >= 0 && grid[x-1][y] == '1')
                            queue.offer(new Point(x-1, y));
                        step[x][y] = 1;

                    }
                }
            }

            return count;
        }

    }


    /**
     * 递归的方式
     */
    static class Solution2 {

        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int count = 0;
            //遍历每一个点
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == '1'){
                        bfs(grid, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        //判断上下左右是否为岛屿
        private void bfs(char[][] grid, int x, int y){
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') return;
            grid[x][y] = '2'; //标记已经访问个的节点
            bfs(grid, x-1, y);//上
            bfs(grid, x+1, y);//下
            bfs(grid, x, y-1);//左
            bfs(grid, x, y+1);//右
        }

    }

    public static void main(String[] args) {
        char[][] nums = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'},
                        };

        char[][] nums2 = {  {'1','1','1'},
                            {'0','1','0'},
                            {'1','1','1'}};

        System.out.println(new NumIslands.Solution2().numIslands(nums));
        System.out.println(new NumIslands.Solution2().numIslands(nums2));
    }
}
