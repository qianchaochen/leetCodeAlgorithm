package com.qcc.string;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月04日18:12
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution14 {

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog", "racecar", "car"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    /**
     * 在遍历的过程中，如果某一行没有了，说明其为最短的单词，
     * 因为共同前缀的长度不能长于最短单词，所以此时返回已经找出的共同前缀。
     * 我们每次取出第一个字符串的某一个位置的单词，
     * 然后遍历其他所有字符串的对应位置看是否相等，如果有不满足的直接返回res，
     * 如果都相同，则将当前字符存入结果，继续检查下一个位置的字符
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char curr = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != curr) {
                    return result;
                }
            }
            result += curr;
        }
        return result;
    }
}
