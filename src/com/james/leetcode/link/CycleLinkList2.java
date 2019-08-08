package com.james.leetcode.link;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 */
public class CycleLinkList2 {

    /**
     * 通过快慢指针来做，如果快指针和慢指针重合即为有环
     * 1.判断是否有环
     * 2.记录已经访问过的节点，如果重复访问就是表示有环
     * 2.返回链表开始入环的第一个节点
     */
    static class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null) return null;
            Set<ListNode> visited = new HashSet<>();
            ListNode node = head;
            while (node != null){
                if(!visited.add(node)){
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }

    /**
     * 不用额外空间解决此题
     * floyd算法
     */
    static class Solution2 {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null) return null;

            ListNode slow = head;
            ListNode fast = head;
            while (true){
                if(fast == null || fast.next == null) return null;
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    break;
                }
            }
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        //n3.next = n4;
        n3.next = n1;
        //ListNode.printAll(head);
        //System.out.println();
        ListNode result = new CycleLinkList2.Solution().detectCycle(head);
        System.out.println(result.val);
        //ListNode result2 = new CycleLinkList2.Solution2().detectCycle(head);
        //System.out.println(result2.val);
    }
}
