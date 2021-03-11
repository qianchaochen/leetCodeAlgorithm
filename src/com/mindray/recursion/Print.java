package com.mindray.recursion;

/**
 * description:
 * created by qianchaochen at 2020-11-14
 */
public class Print {

    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
//        print(arr, 0);
        System.out.println("=====分隔线=====");
        reversePrint(arr, 0);
    }

    /**顺序打印*/
    public static void print(String[] arr, int i) {
        if (i >= arr.length) return;
        System.out.println(arr[i]); //先打印输出,再递归
        print(arr, ++i);
    }

    /**逆序打印*/
    public static void reversePrint(String[] arr, int i) {
        if (i >= arr.length) return;
        reversePrint(arr, ++i);     //先递归,再打印输出
        System.out.println(arr[--i]);
    }

}
