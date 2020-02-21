package com.james.leetcode.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内
 */
public class MyHashSet {
    private final static Integer size = 10000;
    LinkedList<Integer>[] buckets;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[size];
    }

    public void add(int key) {
        if(contains(key)) return;
        int index = index(key);
        LinkedList<Integer> items = buckets[index];
        if(items == null){
            items = new LinkedList<>();
            buckets[index] = items;
        }
        items.add(key);
    }

    public void remove(int key) {
        int index = index(key);
        LinkedList<Integer> items = buckets[index];
        if(items != null){
            items.remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = index(key);
        LinkedList<Integer> items = buckets[index];
        if(items != null){
            return items.contains(key);
        }
        return false;
    }

    private int index(int key){
        return key % size;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)); // 返回 true
        System.out.println(hashSet.contains(3)); // 返回 false (未找到)
        hashSet.add(2);
        System.out.println(hashSet.contains(2)); // 返回 true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2)); // 返回  false (已经被删除)
    }
}
