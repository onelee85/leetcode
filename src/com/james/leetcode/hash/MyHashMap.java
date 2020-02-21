package com.james.leetcode.hash;

/**
 * 哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 注意：
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 */
public class MyHashMap {
    int[] set = new int[1000001];

    public MyHashMap() {
        for(int i=0;i<set.length-1;i++) {
            set[i]=-1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        set[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return set[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        set[key] = -1;
    }

    /**
     *
     *
     * ["MyHashMap","remove","put", "put",  "put",  "put",  "put",  "put",  "get",  "put"," put"]
     * [[],         [2],      [3,11],[4,13],[15,6],[6,15],  [8,8],  [11,0], [11],   [1,10], [12,14]]
     * @param args
     */
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));           // 返回 1
        System.out.println(hashMap.get(3));            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        System.out.println(hashMap.get(2));            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        System.out.println(hashMap.get(2));            // 返回 -1 (未找到)
    }
}
