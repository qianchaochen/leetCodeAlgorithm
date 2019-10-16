package com.qcc;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 804. 唯一摩尔斯密码词
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * <p>
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * <p>
 * 返回我们可以获得所有词不同单词翻译的数量。
 * <p>
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * @Author：create by qianchaochen at 2019年10月13日17:12
 */
public class Solution804 {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int res = uniqueMorseRepresentations(words);
        System.out.println(res);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //循环遍历单词的每一位,将其转码追加到stringBuilder中.然后放入set集合
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 97;
                builder.append(arr[index]);
            }
            //将整个单词转码后的字符放到set中去重
            set.add(builder.toString());
        }
        return set.size();
    }

}
