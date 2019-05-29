package com.james.leetcode.tree;

import java.util.List;
import java.util.Stack;

/**
 *  验证二叉搜索树
 *
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidBST {
    static class Solution {

        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            return validBST(root);
        }
        private TreeNode prev = null;
        private boolean validBST(TreeNode node) {
            if(node == null) return true;
            if(!validBST(node.left)){//左子树是否为二叉搜索树
                return false;
            }
            if(prev != null && prev.val >= node.val)//左子树只包含小于当前节点的数
                return false;
            prev = node;
            return validBST(node.right);//判断右子树是否为二叉搜索树
        }
    }

    static class Solution2 {
        /**
         * 通过中序遍历，判断是否为有序列表
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;
            TreeNode prev = null;
            while(curr != null || !stack.empty()){
                if(curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }else{
                    curr = stack.pop();
                    if(prev != null){
                        if(prev.val >= curr.val) return false;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
            return true;
        }
    }

    /**
            10
           / \
     *    5   15
     *       / \
     *      11   20
     *       \
     *        16
     *
     *      [5,1,4,null,null,3,6]
     *      [10,5,15,null,null,6,20]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(20);
        TreeNode n5 = new TreeNode(12);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.right = n5;
/*        TreeNode.preOrderTraverse1(root);
        System.out.println();
        TreeNode.preOrderTraverse12(root);
        System.out.println();

        TreeNode.inOrderTraverse1(root);
        System.out.println();
        TreeNode.inOrderTraverse12(root);
        System.out.println();

        TreeNode.postOrderTraverse1(root);
        System.out.println();*/

        TreeNode.inOrderTraverse12(root);
        System.out.println();

        List<List<Integer>> result = TreeNode.levelOrder(root);
        System.out.println(result);

        System.out.println(new ValidBST.Solution().isValidBST(root));
        System.out.println(new ValidBST.Solution2().isValidBST(root));
    }
}
