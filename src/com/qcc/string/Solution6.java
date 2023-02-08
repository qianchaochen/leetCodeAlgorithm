package com.qcc.string;

/**
 * 6. N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
/*可以把每行想像成一个队列，字符串一个个入队，最终把队列数据全部打印出来。*/
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String res = solution6.convert("PAYPALISHIRING", 1);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] result = new StringBuilder[numRows];
        //初始化
        for (int i = 0; i < numRows; i++) {
            StringBuilder builder = new StringBuilder();
            result[i] = builder;
        }
        //direction：控制写入方向，1为向下增加，-1为向上减少
        int index=0, row=0, direction=1, len = s.length();
        while (index < len) {
            if(row == numRows-1) direction = -1;
            if(row == 0) direction = 1;
            result[row].append(s.charAt(index++));
            row += direction;
        }

        //遍历所有行，将结果集拼接
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : result) {
            res.append(sb);
        }
        return res.toString();
    }
}
