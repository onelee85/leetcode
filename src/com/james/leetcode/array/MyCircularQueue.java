package com.james.leetcode.array;

/**
 * 实现循环队列
 */
public class MyCircularQueue {

    private int[] queue = null;
    private int len = 0;
    private int count = 0;
    private int headIndex=0, tailIndex= -1;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        if(k > 0){
            len = k;
            queue = new int[k];
        }
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        tailIndex = (tailIndex+1) % len ;
        queue[tailIndex] = value;
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        headIndex = (headIndex+1) % len ;
        count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return queue[headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return  queue[tailIndex];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == len;
    }

    public String toString(){
        return "head:"+headIndex + " tail:"+tailIndex;
    }
    public static void  main(String[] args){
        int k = 3;
        MyCircularQueue obj = new MyCircularQueue(k);
     /*   ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
[[3],[1],[2],[3],[4],[],[],[],[4],[]]*/
        //[null,true,true,true,false,3,true,true,true,4]
        System.out.printf("%s, %s, %s, %s, %s, %s, %s,%s,%s",
                obj.enQueue(1),obj.enQueue(2),obj.enQueue(3), obj.enQueue(4),obj.Rear(), obj.isFull(),
                obj.deQueue(),  obj.enQueue(4), obj.Rear());

    }
}
