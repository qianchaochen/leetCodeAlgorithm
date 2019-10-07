package com.qcc;

import java.util.Arrays;

/**
 * @Description 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * @Author：create by qianchaochen at 2019年10月07日18:19
 */
public class Solution485 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }

    /**
     * dp数组中存放到当前位置的最大连续1的个数
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] == 1 ? 1 : 0;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] == 1 ? dp[i - 1] + 1 : 0;
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
