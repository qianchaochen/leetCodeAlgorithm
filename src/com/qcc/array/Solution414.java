package com.qcc.array;

/**
 * @Description 返回给定数组中的第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * @Author：create by qianchaochen at 2019年10月07日12:41
 */
public class Solution414 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4};
        thirdMax(nums);
    }

    public static int thirdMax(int[] nums) {
        long i=Long.MIN_VALUE, j = Long.MIN_VALUE, k = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > i) {
                k = j;
                j = i;
                i = num;
            } else if (num > j && num < i) {
                k = j;
                j = num;
            } else if (num > k && num < j) {
                k = num;
            }
        }
        if (k == Long.MIN_VALUE || j == k) {
            return (int)i;
        }
        return (int)k;
    }
}
