package com.qcc.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:116.填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoo0ts/
 * created by qianchaochen at 2020/9/7
 */
public class Solution116 {

    /**
     * 二叉树的层次遍历
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


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}