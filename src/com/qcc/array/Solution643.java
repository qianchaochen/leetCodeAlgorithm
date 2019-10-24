package com.qcc.array;

/**
 * @Description 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * @Author qianchaochen
 * @Date 2019年10月08日 15:54
 */
public class Solution643 {

    public static void main(String[] args) {
        int[] nums = {0,1,1,3,3};
//        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }

    /**
     * @Description 滑动窗口方式
     * create by qianchaochen at 2019/10/8 16:51
     */
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;

        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            if (sum > max) max = sum;
        }
        return max / k;
    }

}
