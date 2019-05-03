package com.qcc;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月03日13:32
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */
public class Solution7 {

    public static void main(String[] args) {
        int result = reverse(120);
        System.out.println(result);

        result = reverse(123);
        System.out.println(result);

        result = reverse(-123);
        System.out.println(result);
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if(Math.abs(result)>Integer.MAX_VALUE/10) return 0;
            result = result*10 + x % 10;
            x/=10;
        }
        return result;
    }
}
