package com.qcc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * @Author qianchaochen
 * @Date 2019年10月11日 15:03
 */
public class Solution459 {

    public static void main(String[] args) {
        String s = "a";
        boolean res = repeatedSubstringPattern(s);
        System.out.println("a => " + res);
        s = "aba";
        res = repeatedSubstringPattern(s);
        System.out.println("aba => " + res);
        s = "abcabcabcabc";
        res = repeatedSubstringPattern(s);
        System.out.println("abcabcabcabc => " + res);
        s = "abbaab";
        res = repeatedSubstringPattern(s);
        System.out.println("abbaab => " + res);
    }

    /**
     * 首先一个字符串t重复N次后得到重复字符串s， 那么s = N * t，那么这样的重复字符串截取t后得到的字符串也是重复字符串。
     * 然后得到s1 = s+s，现在的s1 = 2N * t，有2N个t组成。
     * 现在把s1的前后减去一个字符，那么前后的两个t就不再作为重复子字符串而存在了，此时s1相当于(2N-2)*t，如果此时s1中依然能够找到s，说明s完全由t组成。
     *
     * 举例:
     * s = abc|abc; // 2abc
     * s+s = abc|abc|abc|abc; // 4abc
     * s1 = a|bcabcabcab|c = bcabcabcab; // bc + 2*abc + ab
     * 因为一个重复子字符串删除一个子字符串后依然是重复子字符串。
     */
    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).indexOf(s) != -1;
    }

}
