package com.qcc.math;

/**
 * description:665. 非递减数列
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * created by qianchaochen at 2020-8-24
 */
public class Solution665 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        boolean res = checkPossibility(nums);
        System.out.println(res);
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2>=0 && nums[i-2] > nums[i]) nums[i] = nums[i-1];
            }
        }
        return cnt<=1;
    }

}
