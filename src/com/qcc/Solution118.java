package com.qcc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 杨辉三角
 * @Author：create by qianchaochen at 2019年10月05日19:15
 */
public class Solution118 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (int i = 0; i < generate.size(); i++) {
            for (int j = 0; j < generate.get(i).size(); j++) {
                System.out.print(generate.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> item1 = Arrays.asList(1);
            result.add(item1);
            return result;
        }

        List<Integer> item1 = Arrays.asList(1);
        List<Integer> item2 = Arrays.asList(1, 1);
        result.add(item1);
        result.add(item2);
        int current = 2;
        for (int i = 0; i < numRows - 2; i++) {
            List<Integer> item = new ArrayList<>();
            item.add(1);
            List<Integer> preItem = result.get(current - 1);
            for (int j = 0; j < current - 1; j++) {
                item.add(preItem.get(j) + preItem.get(j + 1));
            }
            item.add(1);
            result.add(item);
            current++;
        }

        return result;
    }
}
