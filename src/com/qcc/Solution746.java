package com.qcc;

/**
 * @Description
 * @Author 1
 * @Date 2019年06月16日21:17
 */

/**
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class Solution746 {
    public static int minCostClimbingStairs(int[] cost) {
        //dp[i]代表到达第i个位置需要花费的体力值
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int  result = minCostClimbingStairs(cost);
        System.out.println(result);
    }
}