package com.qcc.array;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月05日21:46
 */

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution66 {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
//        int[] digits = {4,3,2,1};
//        int[] digits = {9,9,9,9};
        int[] res = plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            if (num == 10) {
                carry = 1;
                digits[i]=0;
            } else {
                carry = 0;
                digits[i]=num;
            }
            if(carry ==0) return digits;
        }
        int[] res = new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
