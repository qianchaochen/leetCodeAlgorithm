package com.qcc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @Author：create by qianchaochen at 2019年10月07日1:26
 */
public class Solution217 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean flag = containsDuplicate(nums);
        System.out.println(flag);
        int[] nums2 = {1,2,3,4};
        flag = containsDuplicate(nums2);
        System.out.println(flag);

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        flag = containsDuplicate(nums3);
        System.out.println(flag);
    }
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if(map.containsKey(num)){
                return true;
            }
            map.put(num,num);
        }
        return false;
    }
}
