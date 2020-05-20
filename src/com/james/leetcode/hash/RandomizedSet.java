package com.james.leetcode.hash;

import java.util.*;

/**
 * 常数时间插入、删除和获取随机元素
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class RandomizedSet {
    Map<Integer, Integer> map = null;
    List<Integer> list = null;
    Random random = null;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int lastElement = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        //["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        //[[],[1],[2],[2],[],[1],[2],[]]
        // 预期：[true,false,true,1,true,false,2]
        String[] ops = {"insert","remove","insert","getRandom","remove","insert","getRandom"};
        int[][] values = {{1},{2},{2},{},{1},{2},{}};
        buildTest(ops, values);
        System.out.println("======================");
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],[0],[1],[0],[2],[1],[]]
        //预期：[true,true,true,true,true,2]
        String[] ops1 = {"insert","insert","remove","insert","remove","getRandom"};
        int[][] values1 = {{0},{1},{0},{2},{1},{}};
        buildTest(ops1, values1);
        System.out.println("======================");

        /**
         * 输入：
         * ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
         * [[],[0],[0],[0],[],[0],[0]]
         * 预期：
         * [false,false,true,0,true,true]
         */
        String[] ops2 = {"remove","remove","insert","getRandom","remove","insert"};
        int[][] values2 = {{0},{0},{0},{},{0},{0}};
        buildTest(ops2, values2);
        System.out.println("======================");
    }

    private static void buildTest(String[] ops, int[][] values){
        RandomizedSet randomSet = new RandomizedSet();
        List<Object> results = new ArrayList<>(ops.length);
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]){
                case "insert" : results.add(randomSet.insert(values[i][0])); break;
                case "remove" : results.add(randomSet.remove(values[i][0])); break;
                case "getRandom" : results.add(randomSet.getRandom()); break;
            }
        }
        results.forEach(item -> System.out.print(item+","));
        System.out.println("");
    }
}
