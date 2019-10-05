package com.qcc;

import com.qcc.common.TreeNode;

/**
 * @Description create by qianchaochen at 2019年06月16日22:06
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果两棵树都为空,则返回true;
        if (p == null && q == null) {
            return true;
        }
        //如果两棵树的根节点都不为空,且相同,则比较其对应的左右子树是否相同;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}

