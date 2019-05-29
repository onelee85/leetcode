package com.james.leetcode.link;

/**
 * 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode newList = new ListNode(0);
            ListNode curr = newList;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = l1;//当前指针总是指向值小的那个节点
                    l1 = l1.next;
                } else {
                    curr.next = l2;//当前指针总是指向值小的那个节点
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 != null) {//链表1有剩余
                curr.next = l1;
            }
            if (l2 != null) {//链表2有剩余
                curr.next = l2;
            }
            return newList.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        head1.next = n1;
        n1.next = n2;

        ListNode head2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head2.next = n3;
        //n3.next = n4;

        ListNode.printAll(head1);
        System.out.println();
        ListNode.printAll(head2);
        ListNode head = new MergeTwoLists.Solution().mergeTwoLists(head1, head2);
        System.out.println();
        ListNode.printAll(head);
    }
}
