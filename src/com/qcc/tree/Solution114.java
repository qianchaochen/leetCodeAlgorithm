package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 *
 * @Description: Created by qianchaochen on 2021/5/23
 */
public class Solution114 {
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        preOrder(root);
        //list: 1,2,3,4,5,6
        for (int i = 1; i < list.size(); i++) {
            //第一次获取到的list.get(0)其实就是root，tree和root指向的是同一个对象，通过不断修改tree的right引用，最终使得root的数据结构发生变化
            TreeNode tree = list.get(i - 1);
            tree.left = null;
            tree.right = list.get(i);
        }

    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            list.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }


}
