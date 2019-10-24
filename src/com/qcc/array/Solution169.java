package com.qcc.array;

/**
 * @Description 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Author：create by qianchaochen at 2019年10月06日17:59
 */
public class Solution169 {

    /**
     * 摩尔投票法:当一个数的重复次数超过数组长度的一半，每次将两个不相同的数删除，最终剩下的就是要找的数
     * <p>
     * 先假设第一个数过半数并设cnt=1；遍历后面的数如果相同则cnt+1，不同则减一，
     * 当cnt为0时则更换新的数字为候选数（成立前提：有出现次数大于n/2的数存在）
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else {
                if (res == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}
