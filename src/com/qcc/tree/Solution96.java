package com.qcc.tree;

/**
 *96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *  created by qianchaochen at 2021/05/20 15:16
 */
public class Solution96 {

    //dp数组     1    1    2           i
    //          0    1    2   3   4   5   6   7   8   9
    //1 <= n <=

    /**
     *
     * dp[i] = dp[0]*dp[i-1] + dp[1]*dp[i-2]+...dp[i-1]*d[0]
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int index = 0; index < i; index++) {
                dp[i] += dp[index]*dp[i-index-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution96 s = new Solution96();
        for (int i = 1; i <= 19; i++) {
            System.out.println(i + " → " + s.numTrees(i));
        }
    }
}
