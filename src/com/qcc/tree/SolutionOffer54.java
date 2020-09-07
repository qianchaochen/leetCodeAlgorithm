package com.qcc.tree;

import com.qcc.common.TreeNode;

/**
 * description:剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * created by qianchaochen at 2020/9/7
 */
public class SolutionOffer54 {

    public int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrderReverse(root);
        return res;
    }

    /**
     * 中序遍历输出：left,根,right
     * 中序遍历倒序输出：right,根,left
     * @param root
     */
    public void inOrderReverse(TreeNode root) {
        if (root == null || k == 0) return;
        inOrderReverse(root.right);
        k--;
        if (k == 0) {//如果输出到第k个值，则记录其值到res中，直接终止中序遍历
            res = root.val;
            return;
        }
        inOrderReverse(root.left);
    }

}
