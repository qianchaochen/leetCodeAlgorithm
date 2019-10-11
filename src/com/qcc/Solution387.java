package com.qcc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * @Author qianchaochen
 * @Date 2019年10月11日 9:25
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, 2);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return -1;
            } else if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
