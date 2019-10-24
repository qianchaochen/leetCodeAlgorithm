package com.qcc.dynamicprogramming;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月05日21:23
 */

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
    //求连续最大子序列的和，使用动态规划
    public static int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];//dp[i]代表第i个位置的最大连续和
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }
}
