package com.james.leetcode.link;

/**
 * 双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表
    示例:
 *  输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }

    public static void printAll(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + ",");
            if(curr.child != null){
                printAll(curr.child);
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
