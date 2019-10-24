package com.qcc.string;

/**
 * @Description 686. 重复叠加字符串匹配
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * <p>
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * <p>
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 * <p>
 * 注意:
 * <p>
 *  A 与 B 字符串的长度在1和10000区间范围内。
 * @Author qianchaochen
 * @Date 2019年10月12日 11:31
 */
public class Solution686 {

    public static void main(String[] args) {
        String a = "abcd", b="cdabcdab";
        int res = repeatedStringMatch(a, b);
        System.out.println(res);
    }

    /**
     * @Description 分析：B要想是A的子串，则A重复后的长度要大于等于B
     * 当新字符串str长度大于或等于B的长度时，在str中进行查找B，找到就返回重复的次数；
     * 如果没找到，像abcdabcd中找cdabcdab时，找不到，需要再次重复拼接一次A串.
     * 再次查找，找到就返回count+1,找不到返回-1
     * create by qianchaochen at 2019/10/12 14:01
     */
    public static int repeatedStringMatch(String A, String B) {
        int count = 0;//重复的次数
        String str = "";//重复后生成的新字符串
        while (str.length() < B.length()) {
            str += A;
            count++;
        }
        if (str.indexOf(B) != -1) {
            return count;
        } else {
            str += A;
            return str.indexOf(B) != -1 ? count + 1 : -1;
        }

    }
}
