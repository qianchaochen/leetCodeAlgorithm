package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.*;

/**
 * @Description 102. 二叉树的层次遍历
 * @Author qianchaochen
 * @Date 2019年10月15日 14:27
 */
public class Solution102 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.setLeft(n2);
        n1.setRight(n3);
        n3.setLeft(n4);
        n3.setRight(n5);

        List<List<Integer>> res = levelOrderBottom(n1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();//当前层元素个数
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();//当前队列中的所有元素,一个一个出队,然后把出队元素的左右子树再次放入队列
                if (node != null) {
                    levelList.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            res.add(levelList);//将当前层元素放到的arrayList中后,把这个arrayList插入到res的最后面,正序输出,即自顶向下.
        }

        return res;
    }

}
