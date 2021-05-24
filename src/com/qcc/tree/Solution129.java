package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.*;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * created by qianchaochen at 2021/05/24 14:45
 */
public class Solution129 {
    int res = 0;//保存最终累加和
    Deque<Integer> queue = new LinkedList<>();//双端队列用于在队尾插入数据，在队毛删除数据
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        queue.addLast(root.val);
        //到达叶子节点
        if (root.left == null && root.right == null) {
            //队列中的所有数组成一个数字，添加到res中；
            Iterator<Integer> iterator = queue.iterator();
            int sum = 0;
            while (iterator.hasNext()) {
                sum = sum * 10 + iterator.next();
            }
            res += sum;
        }
        dfs(root.left);
        dfs(root.right);
        queue.removeLast();
    }

    //构建示例树型结构
    public TreeNode build() {
        TreeNode root = new TreeNode(4);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        root.left = t1;
        root.right=t2;
        t1.left=t3;
        t1.right=t4;
        return root;
    }


    public static void main(String[] args) {
        Solution129 solution = new Solution129();
        TreeNode root = solution.build();
        int res = solution.sumNumbers(root);
        System.out.println(res);
    }
}
