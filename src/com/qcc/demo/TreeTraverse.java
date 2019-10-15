package com.qcc.demo;

import com.qcc.common.TreeNode;

import java.util.ArrayDeque;

/**
 * @Description 二叉树的层次遍历
 * 树的层次遍历，就应该提到广度优先搜索算法
 * 广度优先搜索算法（Breadth-First-Search），
 * 又译作宽度优先搜索，或横向优先搜索，简称BFS，是一种图形搜索算法。
 * @Author qianchaochen
 * @Date 2019年10月15日 10:18
 */
public class TreeTraverse {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n4.setLeft(n7);

        levelTraverse(n1);
    }

    /**
     * @Description 层次遍历
     *  树的层次遍历，故名思议，在一棵树中，把节点从左往右，一层一层的，从上往下，遍历输出，这里要用到一种很重要的数据结构，队列。
     * 步骤如下：
     * 1.首先将根节点放入队列中。
     * 2.当队列为非空时，循环执行步骤3到步骤5，否则执行6；
     * 3.出队列取得一个结点，访问该结点；
     * 4.若该结点的左子树为非空，则将该结点的左子树入队列；
     * 5.若该结点的右子树为非空，则将该结点的右子树入队列；
     * 6.结束。
     * create by qianchaochen at 2019/10/15 10:19
     */
    public static void levelTraverse(TreeNode treeNode){
        if(treeNode == null) return;

//        ArrayQueue<TreeNode> queue = new ArrayQueue<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val+ " ");
            if(node.left!=null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }


    }
}
