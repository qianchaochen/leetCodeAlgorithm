package com.qcc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * description:1512. 好数对的数目
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * created by qianchaochen at 2020-8-22
 */
public class Solution1512 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int res = numIdenticalPairs(nums);
        System.out.println(res);
    }

    /**
     * @description: 先统计每个数字出现的次数，并将结果存入到map中。
     * 遍历map，比如数字1出现5次，那么5个1的组合共有5*4/2种方式
     * @author: qianchaochen
     * @date: 2020-8-22
     */
    public static int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > 1) {
                result += count * (count - 1) / 2;
            }
        }

        return result;
    }
}
