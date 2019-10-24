package com.qcc.string;

/**
 * @Description 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @Author qianchaochen
 * @Date 2019年10月12日 9:22
 */
public class Solution557 {

    public static void main(String[] args) {
        String s = "Let's";
        String res = reverseWords(s);
        System.out.println(res);
        System.out.println(res.equals("s'teL"));
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int head = 0, tail = 0, len = chars.length;
        while (tail < len) {
            //找到空格位置，让tail指向空格
            while (tail < len && chars[tail] != ' ') {
                tail++;
            }
            int cur = tail - 1;
            //从head到tail-1进行循环，首尾交换，进行反转
            while (head < cur) {
                char temp = chars[head];
                chars[head] = chars[cur];
                chars[cur] = temp;
                head++;
                cur--;
            }

            //反转完成后，头、尾两指针都指向空格的下一个位置
            tail++;
            head = tail;

        }

        return new String(chars);
    }

}
