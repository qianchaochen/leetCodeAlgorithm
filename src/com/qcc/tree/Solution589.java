package com.qcc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * description:589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *          1
 *
 *   3      2       4
 *
 * 5  6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 * created by qianchaochen at 2020/9/7
 */
public class Solution589 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        preorder2(root);

        return res;
    }
    public void preorder2(Node root) {

        if(root == null) return;
        res.add(root.val);
        for(Node child : root.children) {
            preorder(child);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}


