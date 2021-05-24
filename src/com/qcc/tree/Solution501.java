package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.*;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @Description: Created by qianchaochen on 2021/5/23
 */
public class Solution501 {
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int max = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
            if (map.get(item) > max) max = map.get(item);
        }
        list.clear();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}
