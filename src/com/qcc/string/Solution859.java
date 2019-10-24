package com.qcc.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description 859. 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 示例 1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * <p>
 * 示例 2：
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * <p>
 * 示例 3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * <p>
 * 示例 4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * <p>
 * 示例 5：
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * 提示：
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * @Author qianchaochen
 * @Date 2019年10月14日 14:47
 */
public class Solution859 {

    public static void main(String[] args) {
        String A = "";
        String B= "";
        boolean res = buddyStrings(A, B);
        System.out.println(res);
    }

    /**
     * @Description 分析：
     * 如果A和B长度不相同，则返回false
     * A==B时,如果有重复字符,则返回true
     * A!=B时,如果字符串中相同位置不同的字符超过2个或为1个时,返回false
     * 相同位置字符不相同有2处时,进行交换,如果A==B则返回true,否则返回false;
     * create by qianchaochen at 2019/10/14 14:49
     */
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        HashSet<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if (A.equals(B)) {
            if (A.length() == 0) return false;
            for (char c : A.toCharArray()) {
                set.add(c);
            }
            if (set.size() < A.length()) return true;
        }
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() != 2) return false;
        int i = list.get(0);
        int j = list.get(1);
        return A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i);
    }

}
