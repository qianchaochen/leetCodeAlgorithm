package com.qcc.tree;

import com.qcc.common.TreeNode;

/**
 * @Description 111. 二叉树的最小深度
 * @Author：create by qianchaochen at 2019年10月21日1:11
 */
public class Solution111 {

    /**
     * [1,2]这个树最小深度是2么?为什么不是1?
     * 求最小深度时将Math.max换成Math.min即可，
     * 但要注意如果根节点的左或右子树为空的话是构不成子树的。
     * 而最小深度是要求从根节点到子树的。
     * 当左或右子树为空时，不符合要求。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null)
            return 1 + minDepth(root.right);
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
