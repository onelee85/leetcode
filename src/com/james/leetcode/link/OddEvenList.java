package com.james.leetcode.link;

import java.util.List;

/**
 * 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 */
public class OddEvenList {

    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null) return null;

            ListNode odd = new ListNode(-1); //奇数头
            ListNode event = new ListNode(-1);//偶数头

            ListNode oddTmp = head;
            odd.next = oddTmp;
            ListNode eventTmp = head.next;
            event.next =  eventTmp;
            ListNode tail = null;
            while (oddTmp != null && eventTmp != null){
                if(oddTmp.next != null ){
                    oddTmp.next = oddTmp.next.next;
                    if(oddTmp.next == null){
                        tail = oddTmp;
                    }
                    oddTmp = oddTmp.next;
                }
                if(eventTmp.next != null){
                    eventTmp.next = eventTmp.next.next;
                    eventTmp = eventTmp.next;
                }

            }
            if(tail != null)
                tail.next = event.next;
            else
                oddTmp.next = event.next;
            return odd.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(8);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        /*n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;*/
        ListNode.printAll(head);
        ListNode result = new OddEvenList.Solution().oddEvenList(null);
        ListNode.printAll(result);
    }
}
