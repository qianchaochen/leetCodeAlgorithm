package com.qcc.tree;

import com.qcc.common.TreeNode;

/**
 * @Description 112.路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
 * @Author qianchaochen
 * @Date 2019年10月21日 15:15
 */
public class Solution112 {

    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(1);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t3.left = t6;
        t3.right = t7;
        t2.left = t4;
        t2.right = t5;
        t5.right = t8;
        boolean res = hasPathSum(root, 22);
        System.out.println(res);
    }

    /**
     * @Description 递归,出口是:当前节点为null,返回false;如果当前是叶子节点,且其节点值等于sum值,则返回false
     * 如果没有到达叶子节点,则递归其左右子数.只要有一条返回true,则最终结果为true.
     * create by qianchaochen at 2019/10/21 15:31
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
