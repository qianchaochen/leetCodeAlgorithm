package com.qcc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * @Author：create by qianchaochen at 2019年10月07日1:54
 */
public class Solution219 {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int k = 3;
//        int[] nums = {1, 0, 1, 1};
//        int k = 1;
//        int[] nums = {99,99};
//        int k = 2;
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean res = containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }

    /**
     * 将数组中的数据遍历一遍,维护一个map,将当前正在遍历的数字从map中判断是否存在,
     * 如果存在则看其间隔是否<=K,如果是,直接返回true
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
