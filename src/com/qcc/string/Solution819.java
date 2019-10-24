package com.qcc.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。
 * 返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * 示例：
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * @Author：create by qianchaochen at 2019年10月13日23:50
 */
public class Solution819 {

    public static void main(String[] args) {
//        "Bob. hIt, baLl"
//                ["bob", "hit"]
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};
        String res = mostCommonWord(paragraph, banned);
        System.out.println(res);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        //set集合用于存放禁用的单词,方便调用其contain方法判断单词是否被禁用
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        char[] chars = new char[paragraph.length()];
        //对paragraph字符串进行处理,大写转小写,非字母的字符统一转换为空格" "
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c >= 'a' && c <= 'z')
                chars[i] = c;
            else if (c >= 'A' && c <= 'Z')
                chars[i] = (char) (c + 32);
            else
                chars[i] = ' ';
        }
        String str = new String(chars);
        String[] words = str.split(" ");
        //map集合用于存放【非禁用】单词及出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!"".equals(word) && !set.contains(word)) {//不为空,并且未被禁用
                if (!map.containsKey(word)) {//如果是第一次出现，则次数为1；
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);//否则将其出现的次数加1
                }
            }
        }
        String res = "";//用于记录次数最多的单词
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }

        return res;
    }

}
