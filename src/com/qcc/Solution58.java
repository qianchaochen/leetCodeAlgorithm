package com.qcc;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月05日21:32
 */

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution58 {
    public static void main(String[] args) {
//        String s = "Hello World";
        String s = "ss";
        int res = lengthOfLastWord(s);
        System.out.println(res);
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if(split.length>0) return split[split.length-1].length();
        return 0;
    }
}
