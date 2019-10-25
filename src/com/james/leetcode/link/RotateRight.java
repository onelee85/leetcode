package com.james.leetcode.link;

import org.w3c.dom.NodeList;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {

    static abstract class Solution {
        public abstract ListNode rotateRight(ListNode head, int k);
    }

    /**
     * 方法1:
     * 遍历最后一个节点，把最后一个节点放到头部
     * O(N*K)
     */
    static class Solution1 extends Solution{
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null || head.next == null) return head;
            while (k-- > 0){
                head = rotate(head);
            }
            return head;
        }
        private ListNode rotate(ListNode head){
            ListNode n = head;
            ListNode last = head.next;
            while (last.next != null){
                n = last;
                last = last.next;
            }
            n.next = null;
            last.next = head;
            return last;
        }
    }

    /**
     * 方法2：对K取模
     */
    static class Solution2 extends Solution{
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null || head.next == null) return head;
            ListNode tmp = head;
            int count = 0;
            while (tmp != null){
                tmp = tmp.next;
                count++;
            }
            k = k % count;
            while (k-- > 0){
                head = rotate(head);
            }
            return head;
        }

        private ListNode rotate(ListNode head){
            ListNode n = head;
            ListNode last = head.next;
            while (last.next != null){
                n = last;
                last = last.next;
            }
            n.next = null;
            last.next = head;
            return last;
        }
    }

    public static void main(String[] args) {
        test(new RotateRight.Solution1(), 1300000000);
        System.out.println("test2>>>>>>>>>>>>>>>>>>>>>>>>>");
        test(new RotateRight.Solution2(), 1300000000);

    }

    static void test(Solution s, int k){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a0.next = a1;
        a1.next = a2;
        exec(s , n1, k);
        exec(s , a0, k);
    }

    static void exec(Solution  s, ListNode head, int k){
        //ListNode.printAll(head);
        long begin = System.currentTimeMillis();
        ListNode newNode = s.rotateRight(head, k);
        System.out.println("cost time : " + (System.currentTimeMillis() - begin));
        ListNode.printAll(newNode);
    }
}
