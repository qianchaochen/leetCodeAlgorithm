package com.qcc.string;

/**
 * @Description 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * @Author qianchaochen
 * @Date 2019年10月12日 11:03
 */
public class Solution680 {
    public static void main(String[] args) {
        Solution680 ins = new Solution680();
        String s = "abca";
        System.out.println(ins.validPalindrome(s));
    }

    /**
     * @Description 思路：从左右两端开始验证是否是回文串，验证的过程中，若两个字符不等，再左右各加一或减一，验证一遍
     * create by qianchaochen at 2019/10/12 11:26
     */
    public boolean validPalindrome(String s) {
        if (s.length() <= 2) return true;
        char[] chars = s.toCharArray();
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            if (chars[head] != chars[tail]) {
                return palindrome(chars, head + 1, tail) || palindrome(chars, head, tail - 1);
            }
            head++;
            tail--;
        }
        return true;
    }


    public boolean palindrome(char[] chars, int head, int tail) {
        while (head < tail) {
            if (chars[head] != chars[tail]) return false;
            head++;
            tail--;
        }
        return true;
    }
}
