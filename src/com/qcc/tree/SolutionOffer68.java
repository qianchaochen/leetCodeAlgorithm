package com.qcc.tree;

import com.qcc.common.TreeNode;

/**
 * description:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xopaih/
 * created by qianchaochen at 2020/9/7
 */
public class SolutionOffer68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        //如果left和right都不为空,说明p和q分别在root的两侧
        return root;
    }

}
