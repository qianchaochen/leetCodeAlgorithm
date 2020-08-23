package com.qcc.math;

import java.util.Arrays;

/**
 * description:204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * created by qianchaochen at 2020-8-22
 */
public class Solution204 {
    public static void main(String[] args) {
        /*for (int i = 0; i < 50; i++) {
            boolean flag = isPrime(i);
            if (flag) {
                System.out.println(i + "===>" + isPrime(i));

            }
        }*/

        int res = countPrimesNew(10);
        System.out.println(res);

    }

    //此算法超时 不合格
    public static int countPrimes(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) counter++;
        }
        return counter;
    }

    //改进后：
    public static int countPrimesNew(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) counter++;
        }

        return counter;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return flag;
    }
}
