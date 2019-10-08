package com.qcc;

/**
 * @Description 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @Author qianchaochen
 * @Date 2019年10月08日 15:07
 */
public class Solution628 {

    /**
     * @Description 循环数组，获取前三大与最小的两个数
     * create by qianchaochen at 2019/10/8 15:10
     */
    public int maximumProduct(int[] nums) {
        int max1 = -1001, max2=-1001,max3=-1001,min1=1001,min2=1001;
        for (int num : nums) {
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3=max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num < min2){
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

}
