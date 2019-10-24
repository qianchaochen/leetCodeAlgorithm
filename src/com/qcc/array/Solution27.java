package com.qcc.array;

/**
 * @Description
 * @Author qianchaochen
 * @Date 2019年05月05日 9:07
 */

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution27 {

    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int res = removeElement(nums, val);
        System.out.println(res);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int p=0,q=0;
        while (p<nums.length){
            if(nums[p] == val){
                p++;
            }else{
                nums[q++] = nums[p++];
            }
        }

        //循环输出去掉指定元素后的数组元素
        for (int i = 0; i < q; i++) {
            System.out.println("===> " + nums[i]);
        }

        return q;
    }
}
