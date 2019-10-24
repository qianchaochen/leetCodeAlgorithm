package com.qcc.array;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月05日21:07
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Solution35 {
    public static void main(String[] args) {
        int res = searchInsert(new int[]{1,3,5,6}, 2);
        System.out.println(res);

        res = searchInsert(new int[]{1,3,5,6}, 5);
        System.out.println(res);

        res = searchInsert(new int[]{1,3,5,6}, 7);
        System.out.println(res);

        res = searchInsert(new int[]{1,3,5,6}, 0);
        System.out.println(res);
    }

    /**
     * 使用二分法进行查找，时间复杂度为logN
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(target == nums[mid]) return mid;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
