package com.qcc.array;

/**
 * @Description
 * @Author qianchaochen
 * @Date 2019年05月05日 8:59
 */
/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution26 {

    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);

    }

    /**
     * @Description 那么这道题的解题思路是，我们使用快慢指针来记录遍历的坐标，最开始时两个指针都指向第一个数字，
     * 如果两个指针指的数字相同，则快指针向前走一步，如果不同，则两个指针都向前走一步，
     * 这样当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
     * @Author qianchaochen
     * @Date 2019/5/5 9:04
     * @param nums
     * @return int
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int p=0,q=0;
        while (p<nums.length){
            if(nums[p] != nums[q]){
                nums[++q] = nums[p++];
            }else{
                p++;
            }
        }
        return q+1;
    }
}
