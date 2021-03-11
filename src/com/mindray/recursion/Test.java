package com.mindray.recursion;

public class Test {

    public static void main(String[] args) {
        Integer i = null;
        int j = 1;
        String k = "aaa";

        Object a = true ? i : j;    //1

        Object b = true ? j : i;    //2

        Object c = false ? i : j;   //3

        Object d = false ? j : i;   //4

        Object e = true ? i : k;    //5
    }


    public static void test(){

    }
}
