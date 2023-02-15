package com.qcc.array;

import java.util.Arrays;

public class Solution34 {
    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -10^9 <= target <= 10^9
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums.length==0) return res;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(target == nums[mid]) {
                //找到了，开始找左右边界
                res[0] = mid;
                res[1] = mid;
                low = mid;
                high = mid;
                while (low>0 && nums[low] == nums[--low]){
                    res[0] = low;
                }
                while(high<nums.length-1 && nums[high]==nums[++high]){
                    res[1] = high;
                }
                //找到后直接返回结果
                return res;
            } else if (target < nums[mid]) {
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        //如果出了循环意味着没有找到，直接返回[-1, -1]
        return res;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {6};
        int[] res = solution34.searchRange(nums, 6);
        System.out.println("res:" + Arrays.toString(res));
    }

}
