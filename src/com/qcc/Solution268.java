package com.qcc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * @Author：create by qianchaochen at 2019年10月07日3:01
 */
public class Solution268 {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int res = missingNumber(nums);
        System.out.println(res);

        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        res = missingNumber(nums2);
        System.out.println(res);
    }

    public static int missingNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }
}
