package com.qcc.math;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月04日21:25
 */
public class Test {
    public static void main(String[] args) {
//        randSum();
        minusNumber();
    }

    /**
     * 随机生成10以内的数字加法
     * 幼儿园大二班
     */
    public static void randSum() {
        Random rdm = new Random();
        int i = 1;
        while (i <200) {
            int m = rdm.nextInt(20)+10;
            int n = rdm.nextInt(10);
            if(n==0) {
                n=1;
            }
            if(i%2==0){
                System.out.println(m + " + " + n + " = " + (m + n));
            }else{
                System.out.println(n + " + " + m + " = " + (m + n));
            }
//            int m = (int) Math.random() * 10 + 1;
//            int n = (int) Math.random() * 10 + 1;

            i++;
        }
    }

    public static void minusNumber() {
        Random random = new Random();
        Set<String> set = new HashSet<String>();
        int len = 0;
        while (len<110){
            int num1 = random.nextInt(20) + 1;
            int num2 = random.nextInt(10) + 1;
            if (num1 < num2) {
                num1 += num2;
                num2 = num1 - num2;
                num1 -= num2;
            }
            String result = num1 + " - " + num2 + " = " + (num1 - num2);
            set.add(result);
            len = set.size();
        }
        System.out.println("个数："+set.size());
        for (String s : set) {
            System.out.println(s);
        }
    }

}
