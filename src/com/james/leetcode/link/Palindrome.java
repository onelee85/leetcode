package com.james.leetcode.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Palindrome {

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            List<ListNode> list = new ArrayList<ListNode>();
            ListNode curr = head;
            while (curr != null) {
                list.add(curr);
                curr = curr.next;
            }
            return isPalindrome(list);
        }

        public boolean isPalindrome(List<ListNode> list) {
            if (list.size() == 0) return false;
            if (list.size() == 1) return true; //只有1个字符为回文
            if (list.size() == 2) return list.get(0).val == list.get(1).val; //2个字符相等时为回文
            //超过3个字符串: 外层相等且中间的子字符串也是回文时
            return list.get(0).val == list.get(list.size() - 1).val && isPalindrome(list.subList(1, list.size() - 1));
        }

    }

    static class Solution2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {  //只有1个字符为回文
                return true;
            }
            if (head.next.next == null) { //2个字符相等时为回文
                return head.val == head.next.val;
            }
            //通过快慢指针确定中间节点
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;//慢指针最终会指向中间节点
                fast = fast.next.next;
            }
            //沿中间节点分开，逆序比较2个子链表
            //奇数个节点时会多一个节点
            ListNode curr = slow.next;
            ListNode prev = null;
            while (curr != null) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            //比较2个子链表
            while (head != slow.next && head != null && prev != null) {
                if (head.val != prev.val) return false;
                head = head.next;
                prev = prev.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        /*n3.next = n4;
        n4.next = n5;*/
        ListNode.printAll(head);
        System.out.println();
        boolean isPalindrome = new Palindrome.Solution().isPalindrome(head);
        boolean isPalindrome2 = new Palindrome.Solution2().isPalindrome(head);
        System.out.println(isPalindrome);
        System.out.println(isPalindrome2);
    }
}
