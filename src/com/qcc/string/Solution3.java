package com.qcc.string;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月02日21:31
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Solution3 {

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println("abcabcbb ---" + result);
        result = lengthOfLongestSubstring("bbbbb");
        System.out.println("bbbbb ---" + result);
        result = lengthOfLongestSubstring("pwwkew");
        System.out.println("pwwkew ---" + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = -1;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr) && map.get(curr) > left) {
                left = map.get(curr);
            }
            map.put(curr, i);
            result = Math.max(result, i-left);
        }
        return result;





        /*int left = -1;//滑动窗口的左边界
        int len = 0;//记录最大不重复子串的长度
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);//当前遍历到的字符
            if (map.containsKey(curr) && map.get(curr) > left) {
                left = map.get(curr);
            }
            map.put(curr, i);
            len = i-left;
            max = max>len?max:len;
        }
        return max;*/
    }
}
