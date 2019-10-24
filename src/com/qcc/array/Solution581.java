package com.qcc.array;

/**
 * @Description 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 * 1.输入的数组长度范围在 [1, 10,000]。
 * 2.输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * @Author qianchaochen
 * @Date 2019年10月08日 11:34
 */
public class Solution581 {

    public static void main(String[] args) {
        int[] nums = {2,6,4,8};
        int res = findUnsortedSubarray(nums);
        System.out.println(res);
    }

    /**
     * @Description  问题分析：双指针head和tail分别指向头和尾，如果head指向的元素比后面的所有元素都小，则head++;
     * 如果tail指向的元素比前面的所有元素都大，则tail--
     * 循环退出条件1：head与tail相遇，则说明数组本身就有序。
     * 条件2：head找到比它小的元素，与tail找到比它大的元素，都停止了。
     * create by qianchaochen at 2019/10/8 11:43
     */
    public static int findUnsortedSubarray(int[] nums) {

        int head=0, tail=nums.length-1;
        boolean flagHead=true,flagTail=true;
        while(head<tail){
            if(!flagHead && !flagTail) break;
            for (int i = head; i <=tail ; i++) {
                if(flagHead && nums[i]<nums[head]){//只要发现有一个比head指向的元素小，就停止移动head
                    flagHead = false;
                }
                if(flagTail && nums[i] > nums[tail]){
                    flagTail = false;
                }
            }
            if(flagHead) head++;
            if(flagTail) tail--;
        }

        return head==tail?0:tail-head+1;
    }

}
