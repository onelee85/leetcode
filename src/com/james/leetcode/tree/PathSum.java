package com.james.leetcode.tree;

import java.util.List;

/**
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，[5,4,8,11,null,13,4,7,2,null,null,null,1]
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum {

    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) return false;
            return sum(root, 0, sum);
        }

        private Boolean sum(TreeNode node, int sum, int res){
            sum += node.val;

            //如果符合目标并且为叶子节点
            if(res == sum && node.left == null && node.right == null){
                return true;
            }//左子树继续相加
            else if(node.left != null && sum(node.left, sum, res)){
                return true;
            }else if(node.right != null && sum(node.right, sum, res)){//右子树相加
                return true;
            }
            return  false;
        }
    }

    static class Solution2 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) return false;
            if(root.left == null && root.right == null)//到达叶子节点 判断是否为目标数
                return  root.val == sum;
            if(hasPathSum(root.left, sum - root.val)){//沿左子树继续向下比较
                return true;
            }
            return hasPathSum(root.right, sum - root.val);//右子树继续向下比较;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n8;
        n3.left = n6;
        n3.right = n7;
        List<List<Integer>> result = TreeNode.levelOrder(root);
        System.out.println(result);
        //[-2, null, -3]
        TreeNode root2 = new TreeNode(-2);
        TreeNode n2_1 = new TreeNode(-3);
        root2.right = n2_1;
        //[1,-2,3]
        TreeNode root3 = new TreeNode(1);
        TreeNode n3_1 = new TreeNode(-2);
        TreeNode n3_2 = new TreeNode(3);
        root3.left = n3_1;
        root3.right = n3_2;

        //[1,-2,-3,1,3,-2,null,-1] -1
        TreeNode root4 = new TreeNode(1);
        TreeNode n4_1 = new TreeNode(-2);
        TreeNode n4_2 = new TreeNode(-3);
        TreeNode n4_3 = new TreeNode(1);
        TreeNode n4_4 = new TreeNode(3);
        TreeNode n4_5 = new TreeNode(-2);
        TreeNode n4_6 = new TreeNode(-1);
        root4.left = n4_1;
        root4.right = n4_2;
        n4_1.left = n4_3;
        n4_1.right = n4_4;
        n4_2.left = n4_5;
        n4_2.right = null;
        n4_3.left = n4_6;

        final Solution2 solution = new Solution2();
        System.out.println(solution.hasPathSum(root, 22));
        System.out.println(solution.hasPathSum(root, 21));

        System.out.println(solution.hasPathSum(root2, -5));
        System.out.println(solution.hasPathSum(root2, -4));
        System.out.println(TreeNode.levelOrder(root3));
        System.out.println(solution.hasPathSum(root3, 3));
        System.out.println(TreeNode.levelOrder(root4));
        System.out.println(solution.hasPathSum(root4, -1));
    }
}
