package com.qcc.tree;

import com.qcc.common.TreeNode;

/**
 * @Description 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * @Author：create by qianchaochen at 2019年10月21日0:19
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) < 2;
    }

    public int getTreeHeight(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = getTreeHeight(treeNode.left);
        int right = getTreeHeight(treeNode.right);
        return Math.max(left, right) + 1;
    }

}
