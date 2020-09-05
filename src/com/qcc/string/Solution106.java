package com.qcc.string;

import com.qcc.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 *
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class Solution106 {

    public static int postIndex;
    public int[] postorder;
    public static Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postIndex = postorder.length - 1;
        int idx = 0;
        for (int i : inorder) {
            map.put(i, idx++);
        }
        return helper(0, postIndex);
    }

    public TreeNode helper(int left, int right) {
        if(left>right) return null;
        int rootVal = this.postorder[postIndex];

        TreeNode root = new TreeNode(rootVal);

        int splitLeftAndRightIndex = map.get(rootVal);

        postIndex--;

        root.right = helper(splitLeftAndRightIndex+1, right);
        root.left = helper(left, splitLeftAndRightIndex-1);

        return root;
    }

}
