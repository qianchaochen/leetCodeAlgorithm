package com.qcc;

/**
 * @Description 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @Author：create by qianchaochen at 2019年10月05日16:46
 */
public class Solution64 {

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    public static int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m=grid.length,n=grid[0].length;
        int[][] dp = new int[m][n];
        //填充最后一行和最后一列
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int row=m-2;row>=0;row--){
            dp[row][n - 1] = grid[row][n - 1] + dp[row + 1][n - 1];
        }
        for (int col = n - 2; col >= 0; col--) {
            dp[m - 1][col] = grid[m - 1][col] + dp[m - 1][col + 1];
        }
        //--------------------------------
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
            }
        }

        return dp[0][0];
    }
}
