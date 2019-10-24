package com.qcc.array;

import java.util.Arrays;

/**
 * @Description 283.移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @Author：create by qianchaochen at 2019年10月07日3:31
 */
public class Solution283 {

    public static void main(String[] args) {
//        int[] nums = {0,0,0,0,0};
        int[] nums = {1,1,2,3,4};
//        int[] nums = {4,2,4,0,0,3,0,5,1,0};
//        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 双指针
     * p永远指向第一个为0的位置;q永远指向从p开始的第一个不为0的位置
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int p = 0, q = 1;
        while (p < q && q < len) {
            while (p < len && nums[p] != 0) {
                p++;
            }
            if (p >= len) return;
            q = p + 1;
            while (q < len && nums[q] == 0) {
                q++;
            }
            if (q >= len) return;

            nums[p++] = nums[q];
            nums[q++] = 0;
        }
    }
}