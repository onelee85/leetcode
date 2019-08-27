package com.james.leetcode.link;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * Date: 2019/8/27 14:38
 */
public class AddTwoNumbers {

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode resultHead = new ListNode(-1);
            ListNode currNode = resultHead;
            int remainder = 0;
            while (l1 != null ||  l2 != null){
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                int sum = val1 + val2 + remainder;
                remainder = sum / 10; //余数进位
                currNode.next =  new ListNode(sum % 10);//当前商作为新节点
                currNode = currNode.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if(remainder == 1){
                currNode.next = new ListNode(1);
            }
            return resultHead.next;
        }
    }

    /**
     * 0,1,1,8,5,
     * 0,1,
     * 0,1,
     * 0,1,1,1,1,
     * 0,1,2,
     */
    public static void main(String[] args) {
        ListNode head1 = ListNode.generateByArr(new int[]{1,2,3,4,5});
        ListNode head2 = ListNode.generateByArr(new int[]{9,8,7,3});
        ListNode.printAll(head1);
        ListNode.printAll(head2);
        ListNode result = new AddTwoNumbers.Solution().addTwoNumbers(head1, head2);
        ListNode.printAll(result);
        ListNode.printAll(new AddTwoNumbers.Solution()
                                        .addTwoNumbers(ListNode.generateByArr(new int[]{1}),
                                                         ListNode.generateByArr(new int[]{9})));
        ListNode.printAll(new AddTwoNumbers.Solution()
                .addTwoNumbers(ListNode.generateByArr(new int[]{1}),
                        ListNode.generateByArr(new int[]{9})));

        ListNode.printAll(new AddTwoNumbers.Solution()
                .addTwoNumbers(ListNode.generateByArr(new int[]{1,1,1,1}),
                        ListNode.generateByArr(new int[]{9,9,9,9})));

        ListNode.printAll(new AddTwoNumbers.Solution()
                .addTwoNumbers(ListNode.generateByArr(new int[]{1,1,1}),
                        ListNode.generateByArr(new int[]{9,9})));

    }
}
