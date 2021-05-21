package com.mindray.recursion;

import com.qcc.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 * created by qianchaochen at 2020-11-16
 */
public class TreeDemo {
    public static void main(String[] args) {
        //构建一棵树root
        TreeNode root = new TreeNode(4);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;

        System.out.println("\n层次遍历结果:");
        levelOrder(root);

        System.out.println("\n先序遍历结果:");
        beforeOrder(root);
        System.out.println("\n中序遍历结果:");
        middleOrder(root);
        System.out.println("\n后序遍历结果:");
        afterOrder(root);
    }

    /**先序遍历*/
    public static void beforeOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + "\t");
        beforeOrder(root.left);
        beforeOrder(root.right);
    }

    /**中序遍历*/
    public static void middleOrder(TreeNode root){
        if(root == null) return;
        middleOrder(root.left);
        System.out.print(root.val + "\t");
        middleOrder(root.right);
    }


    /**后序遍历*/
    public static void afterOrder(TreeNode root){
        if(root == null) return;
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val + "\t");
    }


    /**层次遍历*/
    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + "\t");
            if(node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
