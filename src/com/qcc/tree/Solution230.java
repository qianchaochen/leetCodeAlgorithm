package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * created by qianchaochen at 2021/05/29 11:36
 */
public class Solution230 {
    List<Integer> list = new ArrayList<>();
    int count = 0, res = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode root, int k) {
        if (root != null) {
            inOrder(root.left, k);
            count++;
            if(count == k) {
                res = root.val;
                return;
            }
            inOrder(root.right, k);
        }
    }
}
