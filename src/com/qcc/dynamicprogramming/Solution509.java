package com.qcc.dynamicprogramming;

public class Solution509 {

    public static void main(String[] args) {

        int result = fib(5);
        System.out.println(result);
    }

    public static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
