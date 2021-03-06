package com.qcc.string;

/**
 * @Description 541. 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 * @Author：create by qianchaochen at 2019年10月11日22:26
 */
public class Solution541 {

    /**
     * 我们直接翻转每个 2k 字符块。
     * 每个块开始于 2k 的倍数，也就是 0, 2k, 4k, 6k, ...。需要注意的一件是：
     * 如果没有足够的字符，我们并不需要翻转这个块。
     * 为了翻转从 i 到 j 的字符块，我们可以交换位于 i++ 和 j-- 的字符。
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

}
