package com.qcc.math;

import java.util.Random;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月04日21:25
 */
public class Test3 {
    public static int i = 1;
    public static void main(String[] args) {
        while(i<200) {
            randSum();
            minusNumber();
        }
    }

    /**
     * 随机生成20以内的数字加法
     * 幼儿园大二班
     */
    public static void randSum() {
        Random rdm = new Random();
        int m = rdm.nextInt(20);
        int n = rdm.nextInt(20);
        if (n == 0) {
            n = 1;
        }
        if (i % 3 == 0) {
            System.out.println(m + "+" + n);
        } else if (i % 3 == 2) {
            System.out.print(n + "+" + m + "\t\t\t");
        }
        i++;
    }

    public static void minusNumber() {
        if(i%3==1) {
            Random random = new Random();
            int num1 = random.nextInt(20) + 1;
            int num2 = random.nextInt(10) + 1;
            if (num1 < num2) {
                num1 += num2;
                num2 = num1 - num2;
                num1 -= num2;
            }
            System.out.print(num1 + "-" + num2 + "\t\t\t");
            i++;
        }
    }

}
