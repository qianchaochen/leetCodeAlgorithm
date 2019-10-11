package com.qcc;

/**
 * @Description 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * @Author qianchaochen
 * @Date 2019年10月11日 9:33
 */
public class Solution415 {
    public static void main(String[] args) {
        String res = addStrings("12345", "89536");
        System.out.println(res);
    }

    /**
     * @Description 从字符串的尾部开始循环，逐位相加
     * create by qianchaochen at 2019/10/11 9:35
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int tmpSum = 0, carry = 0;//carry:进位
        while (i >= 0 || j >= 0) {
            int m = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n = j >= 0 ? num2.charAt(j) - '0' : 0;
            tmpSum = m + n + carry;
            carry = tmpSum / 10;
            builder.append(tmpSum % 10);
            i--;
            j--;
        }
        if (carry == 1) builder.append(1);

        return builder.reverse().toString();
    }

}
