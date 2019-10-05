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

    TreeNode(int x) {
        val = x;
    }
}
