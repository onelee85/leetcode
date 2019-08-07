package com.james.leetcode.stack;

import java.util.*;

/**
 * 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 *
 * 示例 2：
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *
 */
public class VisitAllRooms {

    /**
     * 广度优先bfs
     * 使用队列FIFO
     */
    static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if(rooms.size() == 1) return Boolean.TRUE;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            Set<Integer> visited = new HashSet<>();
            visited.add(0);
            while (!queue.isEmpty()){
                List<Integer> room = rooms.get(queue.poll());
                for (Integer key : room){
                    if(visited.add(key)){
                        queue.add(key);
                    }
                }
            }
            return visited.size() == rooms.size();
        }
    }


    /**
     * 深度优先dfs
     * 使用栈来实现
     */
    static class Solution1 {

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if(rooms.size() == 1) return Boolean.TRUE;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            Set<Integer> visited = new HashSet<>();
            visited.add(0);
            while (!stack.isEmpty()){
                List<Integer> room = rooms.get(stack.pop());
                for (Integer key : room){
                    if(visited.add(key)){
                        stack.push(key);
                    }
                }
            }
            return visited.size() == rooms.size();
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>(){{add(1);}});
            add(new ArrayList<Integer>(){{add(2);}});
            add(new ArrayList<Integer>(){{add(3);}});
            add(new ArrayList<Integer>());
        }};

        List<List<Integer>> rooms2 = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>(){{add(1);add(3);}});
            add(new ArrayList<Integer>(){{add(3);add(0);add(1);}});
            add(new ArrayList<Integer>(){{add(2);}});
            add(new ArrayList<Integer>(){{add(0);}});
        }};

        List<List<Integer>> rooms3 = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>(){{add(1);}});
        }};
        System.out.println(new VisitAllRooms.Solution().canVisitAllRooms(rooms));
        System.out.println(new VisitAllRooms.Solution().canVisitAllRooms(rooms2));
        System.out.println(new VisitAllRooms.Solution().canVisitAllRooms(rooms3));

        System.out.println(new VisitAllRooms.Solution1().canVisitAllRooms(rooms));
        System.out.println(new VisitAllRooms.Solution1().canVisitAllRooms(rooms2));
        System.out.println(new VisitAllRooms.Solution1().canVisitAllRooms(rooms3));
    }
}
