package com.qcc.string;

/**
 * @Description 125. 验证回文串
 * @Author：create by qianchaochen at 2019年10月10日22:55
 */
public class Solution125 {

    public static void main(String[] args) {
        Solution125 instance = new Solution125();
        boolean res = instance.isPalindrome("0P");
        System.out.println(res);
    }

    /**
     * 思路:使用双指针分别指向字符串的开头和结尾,每次判断两个指针指向的字符是否是有效字符,
     * 然后判断忽略大小写的情况下二者是否相同,如不相同,直接返回false
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if ("".equals(s)) return true;
        int head = 0, tail = s.length() - 1;//头尾指针
        while (head < tail) {
            while (head < tail && !isValidChar(s.charAt(head))) head++;
            while (head < tail && !isValidChar(s.charAt(tail))) tail--;
            char left = s.charAt(head);
            char right = s.charAt(tail);
            if (left >= 'A' && left <= 'Z') left = (char) (left + 32);
            if (right >= 'A' && right <= 'Z') right = (char) (right + 32);
            if (left != right) return false;
            head++;
            tail--;
        }
        return true;
    }

    public boolean isValidChar(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}
