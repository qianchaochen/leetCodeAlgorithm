package com.qcc.string;

/**
 * @Description 345. 反转字符串中的元音字母
 * @Author：create by qianchaochen at 2019年10月11日0:54
 */
public class Solution345 {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        int head = 0, tail = s.length() - 1;
        char[] source = s.toCharArray();
        while (head < tail) {
            while (head < tail && !isVowels(source[head])) head++;
            while (head < tail && !isVowels(source[tail])) tail--;
            char temp = source[tail];
            source[tail] = source[head];
            source[head] = temp;
            head++;
            tail--;
        }
        return new String(source);
    }

    public boolean isVowels(char ch) {
        return (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U');
    }

}
