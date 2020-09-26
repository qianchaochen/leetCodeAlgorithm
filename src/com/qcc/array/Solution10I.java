package com.qcc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * @Description: Created by qianchaochen on 2020/9/26
 */
public class Solution10I {

    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        int result;
        if(n<2){
            result = n;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        map.put(n, result);
        return result;
    }
}
