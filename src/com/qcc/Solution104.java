package com.qcc;

import com.qcc.common.TreeNode;

/**
 * @Description 104. 二叉树的最大深度
 * @Author：create by qianchaochen at 2019年10月05日0:00
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
