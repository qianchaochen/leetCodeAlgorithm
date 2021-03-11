package com.mindray.recursion;

/**
 * description:
 * created by qianchaochen at 2020-11-14
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello，world！";
        String result = reverse(str);
        System.out.println(result);

        System.out.println("===========recurision============");
        char[] chars = str.toCharArray();
        char temp = 0;
        recurision(chars, 0, chars.length-1, temp);
        String res = new String(chars);
        System.out.println(res);
    }
    //hello，world！
    public static String reverse(String str){
        int i=0, j = str.length()-1; char temp;
        char[] chars = str.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            i++; j--;
        }
        return new String(chars);
    }

    public static void recurision(char[] chars, int i, int j, char temp){
        if(i>=j) return;
        if (chars[i] != chars[j]) {//交换chars数组中i和j位置的字符
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        recurision(chars, ++i, --j, temp);
    }


    public static String reverse2(String str){
        StringBuffer buffer = new StringBuffer();
        for (int i = str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            buffer.append(ch);
        }
        return buffer.toString();
    }


}
