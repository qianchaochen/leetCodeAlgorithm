package com.qcc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 532. 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，
 * 且两数之差的绝对值是 k.
 * <p>
 * 示例 1:
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * <p>
 * 示例 2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 * <p>
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 * <p>
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * @Author：create by qianchaochen at 2019年10月07日22:04
 */
public class Solution532 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 5, 4};
        int res = findPairs(nums, 0);
        System.out.println(res);
    }

    /**
     * 这道题给了我们一个含有重复数字的无序数组，还有一个整数k，
     * 让我们找出有多少对不重复的数对(i, j)使得i和j的差刚好为k。
     * 由于k有可能为0，而只有含有至少两个相同的数字才能形成数对，
     * 那么就是说我们需要统计数组中每个数字的个数。
     * 我们可以建立每个数字和其出现次数之间的映射，然后遍历哈希表中的数字，
     * 如果k为0且该数字出现的次数大于1，则结果res自增1；
     * 如果k不为0，且用当前数字加上k后得到的新数字也在数组中存在，则结果res自增1
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0 && entry.getValue() > 1) res++;
            if (k > 0) {
                int target = entry.getKey() + k;
                if (map.containsKey(target)) res++;
            }
        }
        return res;
    }
}
