package com.qcc.math;

import java.util.Random;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月04日21:25
 */
public class Test {
    public static void main(String[] args) {
        randSum();
    }

    /**
     * 随机生成10以内的数字加法
     * 幼儿园大二班
     */
    public static void randSum() {
        Random rdm = new Random();
        int i = 1;
        while (i <100) {
            int m = rdm.nextInt(10)+1;
            int n = rdm.nextInt(10)+1;
//            int m = (int) Math.random() * 10 + 1;
//            int n = (int) Math.random() * 10 + 1;
            System.out.println(m + " + " + n + " = " + (m + n));
            i++;
        }
    }
}
