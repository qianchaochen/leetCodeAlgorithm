package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * created by qianchaochen at 2021/05/29 9:38
 */
public class Solution199 {

    /**
     * 使用二叉树层次遍历，输出每层最后一个元素
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root ==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == size -1) res.add(node.val);//如果是当前层最后一个元素，则放入到结果集中
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }

            }
        }
        return res;
    }
}
