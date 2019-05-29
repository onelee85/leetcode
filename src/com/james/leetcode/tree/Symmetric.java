package com.james.leetcode.tree;

import java.util.List;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 如果同时满足下面的条件，两个树互为镜像：
 *
 * 它们的两个根结点具有相同的值。
 * 每个树的右子树都与另一个树的左子树镜像对称。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Symmetric {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return isMrrior(root.left, root.right);
        }

        private boolean isMrrior(TreeNode n1, TreeNode n2){
            if (n1 == null && n2 == null) return true;
            if (n1 == null || n2 == null) return false;
            //具有相同的根节点
            return  (n1.val == n2.val)
                    && isMrrior(n2.right, n1.left) //左右子树互为镜像
                    && isMrrior(n1.right, n2.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        root.left = n1;
        /* root.right = n2;
       n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;*/

        System.out.println(TreeNode.levelOrder(root));

        System.out.println(new Symmetric.Solution().isSymmetric(root));
    }
}
