package com.qcc.math;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月03日13:52
 */

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution9 {

    public static void main(String[] args) {

    }

    /**
     * 判断是否是回文数，回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 如果是负数，直接返回false；
     * 因为数字的第一位不可能是0，所以判断一下非零数字的最后一位是否是0，如果是返回flase;
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        return reverse(x) == x;
    }

    //数字翻转
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
