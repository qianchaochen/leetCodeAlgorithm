package com.qcc.dynamicprogramming;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月03日18:13
 */

import javax.sound.midi.Soundbank;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Solution198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int result = rob(nums);
        System.out.println(result);
    }

    /**
     * 状态转移方程：dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
     * 这道题的本质相当于在一列数组中取出一个或多个不相邻数，使其和最大。
     * 那么我们对于这类求极值的问题首先考虑动态规划Dynamic Programming来解，
     * 我们维护一个一维数组dp，其中dp[i]表示到i位置时不相邻数能形成的最大和，
     * 那么状态转移方程怎么写呢，
     * 我们先拿一个简单的例子来分析一下，比如说nums为{3, 2, 1, 5}，
     * 那么我们来看我们的dp数组应该是什么样的，首先dp[0]=3没啥疑问，
     * 再看dp[1]是多少呢，由于3比2大，所以我们抢第一个房子的3，当前房子的2不抢，所以dp[1]=3，
     * 那么再来看dp[2]，由于不能抢相邻的，所以我们可以用再前面的一个的dp值加上当前的房间值，
     * 和当前房间的前面一个dp值比较，取较大值当做当前dp值，
     * 所以我们可以得到状态转移方程dp[i] = max(num[i] + dp[i - 2], dp[i - 1]),
     * 由此看出我们需要初始化dp[0]和dp[1]，
     * 其中dp[0]即为num[0]，dp[1]此时应该为max(num[0], num[1])
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int result = dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
