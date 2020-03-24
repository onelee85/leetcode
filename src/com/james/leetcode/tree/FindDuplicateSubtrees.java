package com.james.leetcode.tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * 下面是两个重复的子树：
 *       2
 *      /
 *     4
 * 和
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class FindDuplicateSubtrees {

    /**
     * 穷举所有子树
     * 深度遍历的方式
     * 通过hashmap 如果发现有重复的子树则记录结果
     */
    static class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            Map<String, Integer> treeCount = new HashMap<>();
            List<TreeNode> result = new ArrayList<>();
            traverse(treeCount , result, root);
            return result;
        }

        public static String traverse(Map<String, Integer> treeCount,  List<TreeNode> result, TreeNode treeNode) {
            if (treeNode == null) return "|";
            String str = treeNode.val +","+ traverse(treeCount, result, treeNode.left) +","+traverse(treeCount, result, treeNode.right);
            treeCount.put(str, treeCount.getOrDefault(str, 0) + 1);
            if(treeCount.get(str) == 2){
                result.add(treeNode);
            }
            return str;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        System.out.println(TreeNode.levelOrder(root));

        FindDuplicateSubtrees.Solution solution = new FindDuplicateSubtrees.Solution();
        List<TreeNode> result = solution.findDuplicateSubtrees(root);
        for (TreeNode node : result){
            System.out.println(node.val);
        }
    }
}
