package com.james.leetcode.link;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiao.li@ttpod.com
 * Date: 2019/4/22 17:27
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void printAll(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
        System.out.println();
    }


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * <p>
     * 说明：
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * 你能尝试使用一趟扫描实现
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int index = list.size() - n;
        ListNode removeNode = list.get(index);
        ListNode prvNode = index > 0 ? list.get(index - 1) : null;
        ListNode newNode = null;
        if (prvNode != null) {
            prvNode.next = removeNode.next;
            newNode = head;
        } else {
            newNode = removeNode.next;
        }
        return newNode;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newNode = new ListNode(0);
        ListNode curr = newNode;
        newNode.next = head;
        int length = 0;
        while (head != null) {//链表的长度
            length++;
            head = head.next;
        }
        length = length - n;//定位需要删除节点的前一个节点
        while (length-- > 0) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return newNode.next;
    }
}
