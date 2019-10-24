package com.qcc.array;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 找到数组中所有消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * @Author：create by qianchaochen at 2019年10月07日17:55
 */
public class Solution448 {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(nums);
    }

    /**
     * 对于每个数字nums[i]，如果其对应的nums[nums[i] - 1]是正数，
     * 我们就赋值为其相反数，如果已经是负数了，就不变了，
     * 那么最后我们只要把留下的正数对应的位置加入结果res中即可
     * 因为是正数,说明必然没有这个数字对应的位置出现在数组中.
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) res.add(i + 1);
        }
        return res;
    }

}
