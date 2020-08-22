package com.qcc.string;

/**
 * description:剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * created by qianchaochen at 2020-8-22
 */
public class SolutionOffer58 {

    public static void main(String[] args) {
        String s = "lrloseumgh";
        String res = reverseLeftWords(s, 6);
        System.out.println(res);
    }

    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            buffer.append(s.charAt((i + n) % len));
        }
        return buffer.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        int len = s.length();
        String result = "";
        for (int i = 0; i < len; i++) {
            result += s.charAt((i + n) % len);
        }
        return result;
    }
}
