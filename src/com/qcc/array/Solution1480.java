package com.qcc.array;

/**
 * description:一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * created by qianchaochen at 2020-8-21
 */
public class Solution1480 {

    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        int[] result = runningSum(null);
    }

    /**
     * @description: 使用动态规划来解决
     * 结果集数组动态转移方程为：result[i] = result[i-1] + nums[i]
     * @author: qianchaochen
     * @date: 2020-8-21
     */
    public static int[] runningSum(int[] nums) {
        if(nums == null) return null;
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
}
