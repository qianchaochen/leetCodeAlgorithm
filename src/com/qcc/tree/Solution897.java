package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * description:897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 * 示例 ：
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * <p>
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * created by qianchaochen at 2020/9/7
 */
public class Solution897 {

    List<Integer> list = new ArrayList<>();

    /**
     * 先使用中序遍历，获取递增的序列，然后再递归构建右子树。
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {

        inOrder(root);
        if (list == null || list.size() == 0) return null;

        TreeNode newRoot = new TreeNode(0);
        TreeNode curr = newRoot;
        for (int i = 0; i < list.size(); i++) {
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }
        return newRoot.right;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

}
