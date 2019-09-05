package com.james.leetcode.link;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 扁平化多级双向链表
 *
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 * 示例:
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 * Date: 2019/8/29 16:48
 */
public class Flatten {

    /**
     * 通过列表,利用了额外的空间
     */
    static class Solution {
        public Node flatten(Node head) {
            if(head == null) return null;
            List<Node> list = new ArrayList<>();
            iterate(list, head);
            list.get(0).child = null;
            for (int i = 1; i < list.size(); i++) {
                list.get(i-1).next = list.get(i);
                list.get(i).prev = list.get(i-1);
                list.get(i).child = null;
            }
            return head;
        }

        public void iterate(List<Node> list, Node head) {
            Node curr = head;
            while (curr != null) {
                list.add(curr);
                if(curr.child != null){
                    iterate(list, curr.child);
                }
                curr = curr.next;
            }
        }

    }

    /**
     * 利用stack dfs
     */
    static class Solution2 {
        public Node flatten(Node head) {
            if(head == null) return null;
            Node curr = head;
            Stack<Node> stack = new Stack<>();
            while (curr != null) {
                if(curr.child != null){
                    if(curr.next != null){
                        stack.push(curr.next);
                    }
                    curr.next = curr.child;
                    curr.next.prev = curr;
                    curr.child = null;
                }
                if(curr.next == null && !stack.empty()){
                    curr.next = stack.pop();
                    curr.next.prev = curr;
                }
                curr = curr.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        test2();
    }

    static void test1(){
        Node n1 = new Node(1, null, null, null);
        Node n2 = new Node(2, n1, null, null);
        Node n3 = new Node(3, n2, null, null);
        Node n4 = new Node(4, n3, null, null);
        Node n5 = new Node(5, n4, null, null);
        Node n6 = new Node(6, n5, null, null);
        Node n7 = new Node(7, n3, null, null);
        Node n8 = new Node(8, n7, null, null);
        Node n9 = new Node(9, n8, null, null);
        Node n10 = new Node(10, n9, null, null);
        Node n11 = new Node(11, n8, null, null);
        Node n12 = new Node(12, n11, null, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n11.next = n12;
        n3.child = n7;
        n8.child = n11;
        Node.printAll(n1);
        Node.printAll(new Flatten.Solution2().flatten(n1));
    }

    static void test2(){
        Node n1 = new Node(1, null, null, null);
        Node n2 = new Node(2, n1, null, null);
        Node n3 = new Node(3, n2, null, null);
        Node n4 = new Node(4, n3, null, null);
        Node n5 = new Node(5, n4, null, null);
        Node n6 = new Node(6, n5, null, null);
        Node n7 = new Node(7, n3, null, null);
        Node n8 = new Node(8, n7, null, null);
        Node n9 = new Node(9, n8, null, null);
        Node n10 = new Node(10, n9, null, null);
        Node n11 = new Node(11, n8, null, null);
        Node n12 = new Node(12, n11, null, null);
        n1.child = n2;
        n2.child = n3;
        n3.child = n4;
        n4.child = n5;
        n5.child = n6;
        n7.child = n8;
        n8.child = n9;
        n9.child = n10;
        n11.child = n12;
        n3.child = n7;
        n8.child = n11;
        Node.printAll(n1);
        Node.printAll(new Flatten.Solution2().flatten(n1));
    }
}
