package com.qcc.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。

 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 树中的节点数小于 6000
 * -100<= node.val <= 100
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xorvud/
 * created by qianchaochen at 2020/9/7
 */
public class Solution117 {
    /**
     * 与第116题解法完全相同，使用广度优化算法，进行二叉树的层次遍历，不需要考虑二叉树是否是满二叉树。
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            //遍历同一层级元素
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                //如果不是一层中的最后一个元素，则弹出一个后，队列中队首元素即为弹出元素的next。
                if (i < size - 1) node.next = queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }

}
