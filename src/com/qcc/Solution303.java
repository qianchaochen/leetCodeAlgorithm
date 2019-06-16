package com.qcc;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月12日15:55
 */
//303. 区域和检索 - 数组不可变

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class Solution303 {
    //dp[i+1]表示数组中前i项的和
    private int[] dp;
    public Solution303(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Solution303 instance = new Solution303(nums);
        int result = instance.sumRange(1,2);
        System.out.println(result);
    }
}
