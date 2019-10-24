package com.qcc.string;

/**
 * @Description 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * @Author qianchaochen
 * @Date 2019年10月11日 9:56
 */
public class Solution434 {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (!"".equals(str[i].trim())) count++;
        }
        return count;
    }

}
