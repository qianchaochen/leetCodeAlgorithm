package com.qcc.string;

/**
 * @Description 824. 山羊拉丁文
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 *
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 *
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 示例 1:
 *
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2:
 *
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 说明:
 *
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * 1 <= S.length <= 150。
 *
 * @Author：create by qianchaochen at 2019年10月14日0:50
 */
public class Solution824 {

    public static void main(String[] args) {
        String str = "The quick brown fox jumped over the lazy dog";
        String res = toGoatLatin(str);
        System.out.println(res);
    }

    public static String toGoatLatin(String S) {
        StringBuilder builder = new StringBuilder();
        String[] strs = S.split(" ");
        String vowel = "aeiouAEIOU";
        //I speak Goat Latin
        String newStr = "";
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(vowel.indexOf(str.charAt(0)) != -1) {
                builder.append(str);
            }else{
                builder.append(str.substring(1)).append(str.charAt(0));
            }
            builder.append("ma");
            //根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'
            for(int j=0;j<i+1;j++){
                builder.append("a");
            }

            builder.append(" ");
        }
        return builder.toString().trim();
//        String res = builder.toString();
//        return res.substring(0, res.length()-1);
    }

}
