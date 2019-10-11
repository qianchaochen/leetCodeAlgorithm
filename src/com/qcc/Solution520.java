package com.qcc;

/**
 * @Description 520. 检测大写字母
 * @Author：create by qianchaochen at 2019年10月11日20:39
 */
public class Solution520 {

    /**
     * 两种方法:
     * 方法1:统计单词中的大写字母与小写字母的数量;
     * 方法2:调用字符串的方法转换成大写或小写与自身进行比较.
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        } else if (word.equals(word.toLowerCase())) {
            return true;
        } else {
            //首字母大写,其余的都小写也是true
            String str = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            if (word.equals(str)) return true;
            return false;
        }
    }

    /**
     * 字符串长度为len,大写字母数量为upper,小写字母数量为lower,如果len==upper或len==lower,则返回true
     * 如果upper==1 && s.charAt(0)<'a'说明第一个字母为大写,也返回true,
     * 其它所有情况都返回false
     * @param word
     * @return
     */
    public boolean detectCapitalUse2(String word) {
        int upperCount = 0, lowerCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a') {
                upperCount++;
            } else {
                lowerCount++;
            }
        }
        if (upperCount == word.length()) return true;
        if (lowerCount == word.length()) return true;
        if (upperCount == 1 && word.charAt(0) < 'a') return true;
        return false;

    }

}
