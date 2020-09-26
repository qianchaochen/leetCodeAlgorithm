package com.qcc.tree;

import com.qcc.common.ListNode;
import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description:面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * 示例：
 * 输入：[1,2,3,4,5,null,7,8]
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * created by qianchaochen at 2020/9/7
 */
public class Solution0403 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        List<ListNode> list = new ArrayList<>();//保存结果集，最终转换为数组返回
        Queue<TreeNode> queue = new LinkedList<>();//用于层次遍历
        queue.offer(tree);

        ListNode dummy = new ListNode(0);//虚拟节点；

        while (!queue.isEmpty()) {
            int size = queue.size();

            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curr.next = new ListNode(treeNode.val);
                curr = curr.next;
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);

            }
            list.add(dummy.next);
            dummy.next = null;
        }

        return (ListNode[])list.toArray();
    }


}
