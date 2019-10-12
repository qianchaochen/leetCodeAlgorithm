package com.qcc;

/**
 * @Description 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 * <p>
 * 示例 2：
 * 输入: "here"
 * 输出: "here"
 * <p>
 * 示例 3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 * @Author qianchaochen
 * @Date 2019年10月12日 17:16
 */
public class Solution709 {

    public static void main(String[] args) {
        String res = toLowerCase("LOVELY");
        System.out.println(res);
    }
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        }
        return new String(chars);
    }

}
