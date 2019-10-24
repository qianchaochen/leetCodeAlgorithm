package com.qcc.string;

/**
 * @Description 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @Author：create by qianchaochen at 2019年10月11日0:16
 */
public class Solution344 {

    /**
     * 双指针分别指向数组头尾,然后首尾元素进行交换
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int head = 0, tail = s.length - 1;
        while (head < tail) {
            char temp = s[tail];
            s[tail] = s[head];
            s[head] = temp;
            head++;
            tail--;
        }
    }
}
