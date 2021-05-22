package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * @Description: Created by qianchaochen on 2021/5/22
 */
public class Solution99 {
    private List<Integer> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        //1.中序遍历二叉树，找到顺序错误的节点
        inOrder(root);
        int errNode1 = 0,errNode2 = 0,count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                if(count==0) {
                    errNode1 = list.get(i - 1);
                    errNode2 = list.get(i);
                    count++;
                }else if(count == 1){
                    errNode2 = list.get(i);
                }
            }
        }
        //循环root，修改其中的节点的值
        inOrder(root, errNode1, errNode2);
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

    public void inOrder(TreeNode root, int err1, int err2) {
        if (root != null) {
                inOrder(root.left, err1, err2);
                if(root.val == err1) {
                    root.val = err2;
                }else if(root.val == err2) {
                    root.val = err1;
                }
                inOrder(root.right, err1, err2);
        }
    }

}
