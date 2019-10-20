package com.qcc.tree;

import com.qcc.common.TreeNode;

/**
 * @Description 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author：create by qianchaochen at 2019年10月20日13:17
 */
public class Solution108 {

    public static void main(String[] args) {
        int[] nums = {};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildTree(nums, l, mid - 1);
        treeNode.right = buildTree(nums, mid + 1, r);

        return treeNode;
    }
}
