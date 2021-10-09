package com.qcc.tree;

import com.qcc.common.TreeNode;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * created by qianchaochen at 2021/05/29 12:18
 */
public class Solution297 {

    String res = "";

    //序列化一棵树为字符串
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res += "[" + root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                res += ",null";
            } else {
                queue.offer(node.left);
                res += "," + node.left.val;
            }
            if (node.right == null) {
                res += ",null";
            } else {
                queue.offer(node.right);
                res += "," + node.right.val;
            }

        }
        res += "]";
        return res;
    }

    // 反序列化字符串为一棵树
    public TreeNode deserialize(String data) {
        if (data.length() == 2) return null;
        data = data.substring(1, data.length() - 1);

        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(dataArr[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (dataArr[i].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.valueOf(dataArr[i]));
                queue.offer(node.left);
            }
            i++;
            if (dataArr[i].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.valueOf(dataArr[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

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

//        root = null;
        Solution297 solution = new Solution297();
        String str = solution.serialize(root);
        System.out.println(str);
        //String aa = "[4, 2, 6, 1, 3, 5, 7, null, null, null, null, null, null, null, null]";
        //TreeNode test = new TreeNode(1);
        TreeNode res = solution.deserialize(str);
        System.out.println(res);
    }

}
