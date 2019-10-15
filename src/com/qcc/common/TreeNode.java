package com.qcc.common;

/**
 * @Description 通用的树节点对象treeNode
 *  val  : 节点的值
 *  left : 左子树
 *  right: 右子树
 * @Author：create by qianchaochen at 2019年10月05日11:16
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int x) {
        val = x;
    }
}
