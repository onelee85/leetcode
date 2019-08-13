package com.james.leetcode.link;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 * 在节点 c1 开始相交。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionNode {
    static abstract class Solution {
        public abstract ListNode getIntersectionNode(ListNode headA, ListNode headB);
    }

    /**
     * 通过hash的模式
     * O(nm) 时间复杂度
     * O(n) 空间复杂度
     */
    static class Solution1 extends Solution{
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            Set<ListNode> sets = new HashSet<>();
            ListNode tmp = headA;
            while (tmp != null){
                sets.add(tmp);
                tmp = tmp.next;
            }
            tmp = headB;
            while (tmp != null){
                if(!sets.add(tmp)){
                    return tmp;
                }
                tmp = tmp.next;
            }
            return null;
        }
    }

    /**
     * 双指针， 定义2个指针（P1,P2）同时遍历链表
     * 如果P1遍历完，则指向H2的头结点
     * 如果P2遍历完，则指向H1的头结点
     * 少的节点多走几步，回到同一起跑线，最后有相交节点
     */
    static class Solution2 extends Solution{
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode p1 = headA;
            ListNode p2 = headB;
            int count = 0;
            while (count < 2){
                if(p1.equals(p2)){
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
                if(p1 == null){
                    p1 = headB;
                    count++;
                }
                if(p2 == null){
                    p2 = headA;
                    count++;
                }
            }
            while (p1 != null && p2 != null){
                if(p1.equals(p2)){
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return null;
        }
    }
    public static void main(String[] args) {
        test1(new IntersectionNode.Solution2());
        test2(new IntersectionNode.Solution2());
        test3(new IntersectionNode.Solution2());
    }

    public static void test1(Solution solution){
        ListNode head = new ListNode(4);
        ListNode n1 = new ListNode(1);
        ListNode ref = new ListNode(8);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = ref;
        ref.next = n3;
        n3.next = n4;
        ListNode.printAll(head);

        ListNode head2 = new ListNode(5);
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        head2.next = a1;
        a1.next = a2;
        a2.next = ref;
        ref.next = a4;
        a4.next = a5;
        ListNode.printAll(head2);

        ListNode result = solution.getIntersectionNode(head, head2);
        System.out.println(result.val);
    }


    public static void test2(Solution solution){
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(1);
        ListNode ref = new ListNode(2);
        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = ref;
        ref.next = n4;
        ListNode.printAll(head);

        ListNode head2 = new ListNode(3);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        head2.next = ref;
        ListNode.printAll(head2);

        ListNode result = solution.getIntersectionNode(head, head2);
        System.out.println(result.val);
    }


    /**
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     */
    public static void test3(Solution solution){
        ListNode head = new ListNode(2);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        ListNode.printAll(head);

        ListNode head2 = new ListNode(1);
        ListNode a1 = new ListNode(5);
        head2.next = a1;
        ListNode.printAll(head2);

        ListNode result = solution.getIntersectionNode(head, head2);
        System.out.println(result);
    }
}
