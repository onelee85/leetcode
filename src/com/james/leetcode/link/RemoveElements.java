package com.james.leetcode.link;

/**
 *
 * 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode tmp = head;
            ListNode prev = null;
            while(tmp != null){
                if(tmp.val == val){
                    //如果删除的为头
                    if(prev == null){
                        head = tmp.next;
                        tmp = tmp.next;
                        continue;
                    }else{
                        prev.next = prev.next.next;
                        tmp = tmp.next;
                        continue;
                    }
                }
                prev = tmp;
                tmp = tmp.next;
            }
            return head;
        }
    }

    static class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            //先删除前部分 head
            while (head != null && head.val == val){
                head = head.next;
            }
            //删除后部分
            ListNode prev = head;
            while (prev != null && prev.next != null){
                if(prev.next.val == val){
                    prev.next = prev.next.next;
                }else{
                    prev = prev.next;
                }
            }

            return head;
        }
    }

    /**
     * [1,2,2,1]
     * 2
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode.printAll(head);
        ListNode result = new RemoveElements.Solution2().removeElements(head, 6);
        ListNode.printAll(result);

        ListNode head2 = new ListNode(1);
        ListNode n2_1 = new ListNode(1);
        head2.next = n2_1;
        ListNode.printAll(head2);
        ListNode result2 = new RemoveElements.Solution2().removeElements(head2, 1);
        ListNode.printAll(result2);


        ListNode head3 = new ListNode(1);
        ListNode n3_1 = new ListNode(2);
        ListNode n3_2= new ListNode(2);
        ListNode n3_3 = new ListNode(1);
        head3.next = n3_1;
        n3_1.next = n3_2;
        n3_2.next = n3_3;
        ListNode.printAll(head3);
        ListNode result3 = new RemoveElements.Solution2().removeElements(head3, 1);
        ListNode.printAll(result3);
    }
}
