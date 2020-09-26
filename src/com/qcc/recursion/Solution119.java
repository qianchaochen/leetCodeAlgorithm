package com.qcc.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:
 * created by qianchaochen at 2020-9-26
 */
public class Solution119 {

    /**
     * 纯递归解法，超时
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0) return res;

        for(int i = 1; i < rowIndex; i++) {
            res.add(getRow(rowIndex - 1).get(i - 1) + getRow(rowIndex - 1).get(i));
        }
        res.add(1);
        return res;
    }

    /**
     * 动态规划解法
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> dp = new ArrayList<>();
        if(rowIndex == 0) return Arrays.asList(1);
        if(rowIndex == 1) return Arrays.asList(1, 1);
        dp.add(Arrays.asList(1));
        dp.add(Arrays.asList(1, 1));
        for (int i = 2; i <= rowIndex; i++) { //i控制行
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {//j控制列
                row.add(dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
            }
            row.add(1);
            dp.add(row);
        }
        return dp.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> res = getRow2(3);
        System.out.println(res);
    }
}
