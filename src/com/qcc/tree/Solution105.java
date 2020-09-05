package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * description:105.从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoei3r/
 * created by qianchaochen at 2020/9/5
 */
public class Solution105 {

    public int[] preorder;
    public int preIndex;
    public Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.preIndex = 0;
        int idx = 0;
        for (int i : inorder) {
            map.put(i, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    /**
     * 思路：对于任意一颗树而言，前序遍历的形式总是
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
     * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
     * 细节
     * 在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做的时间复杂度较高。我们可以考虑使用哈希映射（HashMap）来帮助我们快速地定位根节点。对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。在构造二叉树的过程之前，我们可以对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。在此后构造二叉树的过程中，我们就只需要 O(1)O(1) 的时间对根节点进行定位了。
     * @param left
     * @param right
     * @return
     */
    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        preIndex++;

        int splitLeftAndRightIndex = map.get(rootVal);

        root.left = helper(left, splitLeftAndRightIndex - 1);
        root.right = helper(splitLeftAndRightIndex + 1, right);

        return root;
    }
}
