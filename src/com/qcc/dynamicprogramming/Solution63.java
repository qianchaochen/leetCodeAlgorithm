package com.qcc.dynamicprogramming;

/**
 * @Description 不同路径(含障碍物)
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Solution63 {

    public static void main(String[] args) {
        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0] == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;//m行n列
        int[][] dp = new int[m][n];
        fillLastRow(obstacleGrid, m, n, dp);
        fillLastColumn(obstacleGrid, m, n, dp);
        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j >=0; j--) {
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 填充最后一行
     * @param obstacleGrid
     * @param m
     * @param n
     */
    public static void fillLastRow(int[][] obstacleGrid, int m, int n, int[][] dp){
        boolean flag = false;
        for (int i = n-1; i >=0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                flag = true;
            }
            if(!flag) {
                dp[m-1][i]=1;
            }else{
                dp[m-1][i]=0;
            }
        }
    }

    /**
     * 填充最后一列
     * @param obstacleGrid
     * @param m
     * @param n
     * @param dp
     */
    public static void fillLastColumn(int[][] obstacleGrid, int m, int n, int[][] dp){
        boolean flag = false;
        for (int i = m-1; i >=0; i--) {
            if (obstacleGrid[i][n-1] == 1) {
                flag = true;
            }
            if(!flag) {
                dp[i][n-1]=1;
            }else{
                dp[i][n-1]=0;
            }
        }
    }
}
