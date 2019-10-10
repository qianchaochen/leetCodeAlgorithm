package com.qcc;

/**
 * @Description 38.报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * @Author：create by qianchaochen at 2019年10月10日20:11
 */
public class Solution38 {

    public static void main(String[] args) {
        Solution38 ins = new Solution38();
        String res = ins.countAndSay(5);
        System.out.println("======" + res);
   }

    public String countAndSay(int n) {
        String[] says = new String[n];
        says[0] = "1";
        System.out.println(says[0]);
        for (int i = 1; i < n; i++) {
            says[i] = read(says[i - 1]);
            System.out.println(says[i]);
        }
        return says[n - 1];

    }

    public String read(String str) {
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        //str:111221读做3个1,2个2,1个1,即312211
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {//循环走到最后一个数,或者当前位置和下一个位置数字不一样时
                buffer.append(count).append(str.charAt(i));
                count = 1;//将count重置为1,即与当前数字不相同的下一个数字的默认个数
            }
        }
        return buffer.toString();
    }

}
