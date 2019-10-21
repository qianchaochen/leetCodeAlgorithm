package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @Author qianchaochen
 * @Date 2019年10月21日 16:56
 */
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        //叶子节点
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }

        if (root.left != null) {
            for (String s : binaryTreePaths(root.left)) {
                list.add(root.val + "->" + s);
            }
        }
        if (root.right != null) {
            for (String s : binaryTreePaths(root.right)) {
                list.add(root.val + "->" + s);
            }
        }
        return list;
    }

}
