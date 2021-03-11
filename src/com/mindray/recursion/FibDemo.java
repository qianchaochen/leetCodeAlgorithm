package com.mindray.recursion;

/**
 * description:
 * created by qianchaochen at 2020-11-14
 */
public class FibDemo {

    public static void main(String[] args) {
//        long res = fib(5);
        long res = 0;
        res = fib(5);
//        for (int i = 1; i <= 5; i++) {
        System.out.print(res + "\t");
//        }
    }

    public static long fib(int n) {

        if (n < 3) return 1;    //递归的出口条件
        return fib(n - 1) + fib(n - 2);//递推公式
    }

    /**
     * n层楼梯, 一步走一层或两层,多少种走法?
     */
    public static long floor(int n) {
        //1: 一种;    2:两种
//        if (n < 3) return n;
        if (n == 1) return 1;
        if (n == 2) return 2;

        return floor(n - 1) + floor(n - 2);
    }

}
