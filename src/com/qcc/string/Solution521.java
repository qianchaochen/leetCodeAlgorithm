package com.qcc.string;

/**
 * @Description 521. 最长特殊序列 Ⅰ
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 * <p>
 * 示例 :
 * <p>
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解析: 最长特殊序列可为 "aba" (或 "cdc")
 * 说明:
 * <p>
 * 两个字符串长度均小于100。
 * 字符串中的字符仅含有 'a'~'z'。
 * @Author：create by qianchaochen at 2019年10月11日21:47
 */
public class Solution521 {

    /**
     * 独有指的是只有自己有，另一个字符串没有
     * 举例说明，设两个字符串变量名分别为 a 和 b
     * a = 'cd', b = 'c'，'cd' 是 a 独有的，所以最长子序列为 'cd'，长度为 2
     * a = 'cd', b = 'cd', 'cd', 'c', 'd' 在两个字符串中都有，所以不存在独有的最长子序列，返回 -1
     * 通过举例分析，得出以下结论：
     * 如果两个字符串长度不一样，则较长的字符串本身不可能是短字符串的子序列，直接返回其长度即可
     * 如果两个字符串内容相等，那么他们独有的最长子序列不存在，返回 -1
     * 如果两个字符串长度相等,内容不同,则其中任意一个字符串都不是另一个串的子串.
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }

}
