package com.qcc.string;

/**
 * @Description 551.学生考勤记录
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * @Author qianchaochen
 * @Date 2019年10月12日 9:14
 */
public class Solution551 {

    /**
     * @Description 统计字符串中的A的次数，超过1直接返回false;
     * 当前字母为A或P时，清空连续字符L的个数。当连续L的个数>=3时说明有三个及以上的迟到，直接返回false;
     * create by qianchaochen at 2019/10/12 9:20
     */
    public boolean checkRecord(String s) {
        int aCount = 0, lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                aCount++;
                lCount = 0;
                if (aCount > 1) return false;
            } else if (c == 'L') {
                lCount++;
                if (lCount >= 3) return false;
            } else {
                lCount = 0;
            }
        }
        return true;
    }

}
