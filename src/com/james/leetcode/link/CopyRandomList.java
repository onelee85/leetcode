package com.james.leetcode.link;

/**
 *  复制带随机指针的链表
 *
 *  给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。要求返回这个链表的深拷贝。 
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 * 提示：
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 */
public class CopyRandomList {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        public static void printAll(Node head) {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.val + ",");
                if(curr.random != null){
                    System.out.print("r="+curr.random.val + ",");
                }
                curr = curr.next;
            }
            System.out.println();
        }
    }

    /**
     * 难点在于后面的节点由于random节点会先生成出来
     */
    static class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            //先在每个接点后插入一个节点
            Node l1 = head;
            while (l1 != null){
                Node n = new Node(l1.val, null, null);
                n.next = l1.next;
                l1.next = n;
                l1 = n.next;
            }
            //新节点de随机节点指向下个随机节点
            l1 = head;
            while (l1.next != null){
                if(l1.random != null)
                    l1.next.random = l1.random.next;
                if(l1.next.next == null) break;
                l1 = l1.next.next;
            }
            //拆分新节点和老节点
            l1 = head;
            Node newhead = l1.next;
            Node l2 = newhead;
            while (l1 != null){
                l1.next = l2.next;
                if(l2.next != null)
                l2.next = l2.next.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            return newhead;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1(){
        Node n2 = new Node(2, null, null);
        n2.random = n2;
        Node n1 = new Node(1, n2, n2);
        Node.printAll(n1);
        Node newHead = new CopyRandomList.Solution().copyRandomList(n1);
        Node.printAll(newHead);
    }

    static void test2(){
        Node n4 = new Node(4, null, null);
        Node n3 = new Node(3, n4, null);
        Node n2 = new Node(2, n3, n4);
        Node n1 = new Node(1, n2, n2);
        n4.random = n1;
        Node.printAll(n1);
        Node newHead = new CopyRandomList.Solution().copyRandomList(n1);
        Node.printAll(newHead);
    }

    static void test3(){
        Node n1 = new Node(1, null, null);
        Node.printAll(n1);
        Node newHead = new CopyRandomList.Solution().copyRandomList(n1);
        Node.printAll(newHead);
    }
}
