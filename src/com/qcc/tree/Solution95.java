package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 * created by qianchaochen at 2021/05/20 10:44
 */

public class Solution95 {

    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);//左子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);//右子树集合
            //从左子树集合中取一棵树，右子树集合中取一棵树，组合当前节点i，生成一棵新的树，放入结果集中
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = leftTree;
                    curr.right = rightTree;
                    list.add(curr);
                }
            }
        }
        return list;
    }
}
