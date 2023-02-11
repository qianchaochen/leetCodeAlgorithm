package com.qcc.string;

public class Solution8 {

    public static int myAtoi(String s) {
        if(s.equals("")) return 0;
        int index = 0, sign = 1;
        //去除前导空格
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(index) == ' ') {
                index++;
            }else{
                break;
            }
        }
        if (index == s.length()) {
            return 0;
        }

        //判断空格后的第一个字符是否是+、-、0-9
        char first = s.charAt(index);
        if (first> '9' ||first< '0') {
            if(first == '+') {
                sign = 1;
                index++;
            } else if (first == '-') {
                sign = -1;
                index++;
            } else{
                //空格后的第一个字符非数字，不是+，不是-，直接返回0
                return 0;
            }
        }

        int res = 0;
        while(index < s.length() && s.charAt(index) <= '9' && s.charAt(index) >= '0'){
            if(sign == 1 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(index) > '7'))
                    || (sign == -1 && (res * sign < Integer.MIN_VALUE / 10 || (res * sign == Integer.MIN_VALUE / 10 && s.charAt(index) > '8')))){
                return sign == 1 ? Integer.MAX_VALUE :  Integer.MIN_VALUE;
            }
            res *= 10;
            res += s.charAt(index) - '0';
            index++;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        myAtoi("     1");
    }
}
