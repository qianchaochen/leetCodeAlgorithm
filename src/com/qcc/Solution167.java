package com.qcc;

import java.util.HashMap;

/**
 * @Description 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 *  @Author：create by qianchaochen at 2019年10月05日21:00
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            if (map.containsKey(another)) {
                //找到了
                result[0] = map.get(another);
                result[1] = i+1;
                break;
            }else{
                map.put(numbers[i], i + 1);
            }
        }
        return result;
    }


    /**
     * 数组有序,使用两根指针从首尾同时开始循环.如果和大于target,则尾指针向前移;
     * 如果和小于target,则头指针向后移.
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0, j=numbers.length-1; i < j; ) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
}
