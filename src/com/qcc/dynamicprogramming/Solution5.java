package com.qcc.dynamicprogramming;

/**
 * created by qianchaochen at 2021/05/15 9:40
 */
public class Solution5 {

    public static String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int len = s.length();
        int max = 1;//最大长度
        int start=0, end = 0;//开始和结束位置
        boolean[][] dp = new boolean[len][len];

        //初始化长度为1的都是true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] arr = s.toCharArray();

        //枚举子串长度
        int sublen = 2;
        for (; sublen <= len; sublen++) {
            for (int i = 0; i <= len-sublen; i++) {
                int j = sublen + i -1;//sublen = j-i+1
                if(arr[i] != arr[j]){
                    dp[i][j] = false;
                } else{
                    if(j-1 - (i+1) >= 1){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && sublen > max) {
                    max = sublen;
                    start = i;
                    end = sublen + i - 1;
                }
            }
        }

        return s.substring(start, end + 1);

    }

    public static void main(String[] args) {
        String res = longestPalindrome("abadcaeacd");
        System.out.println("abcd:" + "abcd".substring(1,2));
        System.out.println(res);
    }
}
