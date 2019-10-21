package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 103. 二叉树的锯齿形层次遍历
 * @Author：create by qianchaochen at 2019年10月15日22:29
 */
public class Solution103 {

    /**
     * 二叉树的锯齿形层次遍历:
     * 第1行从左到右,第2行从右到左;
     * 声明一个count=0,当count是偶数时从左到右;
     * 每次从队列中取出元素后,将其节点值按顺序插入到levelList中;
     * 当为奇数时,将节点值插入到levelList的最前面;
     * if (count % 2 == 0) {
     *     levelList.add(node.val);
     * } else {
     *     levelList.add(0, node.val);
     * }
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (count % 2 == 0) {
                        levelList.add(node.val);
                    } else {
                        levelList.add(0, node.val);
                    }
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            res.add(levelList);
            count++;
        }
        return res;
    }

}
