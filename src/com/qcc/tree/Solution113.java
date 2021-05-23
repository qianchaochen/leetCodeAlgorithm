package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.*;

/**
 * @Description: Created by qianchaochen on 2021/5/22
 */
public class Solution113 {

    /**
     * 113. 路径总和 II
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     * 示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     *
     * 示例 3：
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     */
    List<List<Integer>> res = new ArrayList<>();
    //此处需要使用双向队列，在队列尾部插入数据，在尾部删除数据，而Qeque队列只能在队尾插入，队头删除
    Deque<Integer> queue = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    //Depth First Search遍历二叉树
    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        //将当前元素添加到队列中
        queue.addLast(root.val);
        //如果到达叶子节点，且路径和为0，将该队列中的数据添加到结果集中
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new LinkedList<>(queue));
        }
        dfs(root.left, sum-root.val);
        dfs(root.right, sum-root.val);
        //不管是否满足路径和为sum，都要把队列的最后一个元素移除，进行回溯
        queue.removeLast();
    }

}
