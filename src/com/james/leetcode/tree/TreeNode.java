package com.james.leetcode.tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    /**
     * 前序遍历 先访问 根节点->左节点->右节点
     */
    public static void preOrderTraverse1(TreeNode root){
        if(root == null) return ;
        System.out.print(root.val+",");
        preOrderTraverse1(root.left);
        preOrderTraverse1(root.right);
    }

    /**
     * 前序遍历-非递归
     */
    public static void preOrderTraverse12(TreeNode root){
        if(root == null) return ;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !stack.empty()){
            if(curr != null){
                System.out.print(curr.val+",");
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    /**
     * 中序遍历 先访问 左节点->根节点->右节点
     */
    public static void inOrderTraverse1(TreeNode root){
        if(root == null) return ;
        inOrderTraverse1(root.left);
        System.out.print(root.val+",");
        inOrderTraverse1(root.right);
    }


    /**
     * 中序遍历-非递归
     */
    public static void inOrderTraverse12(TreeNode root){
        if(root == null) return ;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !stack.empty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                System.out.print(curr.val+",");
                curr = curr.right;
            }
        }
    }

    /**
     * 后续遍历 先访问 左节点->右节点->根节点
     */
    public static void postOrderTraverse1(TreeNode root){
        if(root == null) return ;
        postOrderTraverse1(root.left);
        postOrderTraverse1(root.right);
        System.out.print(root.val+",");
    }

    /**
     * 最大深度
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        //找到的左子树
        int left = maxDepth(root.left) + 1;
        //找到的右子树
        int right = maxDepth(root.right) + 1;
        //返回最深的子树深度
        if(left > right)
            return left;
        return right;
    }

    /**
     * 最大深度 非递归
     * */
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        while (!nodeList.isEmpty()){
            int count = nodeList.size();
            depth++;
            for (int i = 0; i < count; i++) {
                TreeNode subNode = nodeList.poll();
                if(subNode.left != null)
                    nodeList.add(subNode.left);
                if(subNode.right != null)
                    nodeList.add(subNode.right);
            }
        }
        return depth;
    }

    /**
     * 层次遍历
     *
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.add(root);
        while (!nodeList.isEmpty()){
            int count = nodeList.size();
            List<Integer> valueList = new ArrayList<Integer>();
            for (int i = 0; i < count; i++) {
                TreeNode subNode = nodeList.poll();
                valueList.add(subNode.val);
                if(subNode.left != null)
                    nodeList.add(subNode.left);
                if(subNode.right != null)
                    nodeList.add(subNode.right);
            }
            result.add(valueList);
        }
        return result;
    }
}
