package com.qcc;

import java.util.Arrays;

/**
 * @Description 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * @Author qianchaochen
 * @Date 2019年10月12日 15:21
 */
public class Solution696 {

    public static void main(String[] args) {
        String str = "00110011";
        int res = countBinarySubstrings(str);
        System.out.println(res);
    }

    /**
     * @Description 统计连续出现的0或1的个数，放到数组中，数组【2,3】表示 “00111” 或 “11000”。
     * 显然，我们可以在此字符串中生成 min(counts[i], counts[i+1]) 有效的二进制字符串。
     * 00110011 转换成[2,2,2,2]数组
     * create by qianchaochen at 2019/10/12 15:26
     */
    public static int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[s.length()];
        int p = 0;//记录数据填写到counts数组中的哪个位置
        counts[0] = 1;
        int sum = 0, count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                counts[p] = count;
                p++;
                count = 1;
            }
        }
        counts[p] = count;
        for (int i = 0; i < p; i++) {
            sum += Math.min(counts[i], counts[i + 1]);
        }
        return sum;
    }

}
