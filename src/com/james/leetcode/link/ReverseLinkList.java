package com.james.leetcode.link;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkList {

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            return prev;
        }
    }

    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);//假设后续是已经翻转的 1->2->3->4<-5
            head.next.next = head; //翻转节点
            head.next = null;
            return p;//返回以翻转的部分链表
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode.printAll(head);
        //head = new ReverseLinkList.Solution().reverseList(head);
        //head = new ReverseLinkList.Solution1().reverseList(head);
        System.out.println();
        ListNode newNode = head.removeNthFromEnd2(head, 1);
        ListNode.printAll(newNode);
    }
}
