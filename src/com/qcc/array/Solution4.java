package com.qcc.array;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = mergeArr(nums1, nums2);
        int len = res.length;
        if (len % 2 == 1) {
            return res[(len - 1) / 2];
        } else {
            return ((double) res[len / 2] + (double) res[len / 2 - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        int[] brr = {2, 4, 6};
        int[] res = mergeArr(arr, brr);
        for (int item : res) {
            System.out.println(item);
        }
    }

    public static int[] mergeArr(int[] arr, int[] brr) {
        int[] result = new int[arr.length + brr.length];
        //i:arr的指针，j:brr的指针，k:result的指针
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {
            //brr数组已全部处理完，直接把arr的合并到result中
            if (i < arr.length && j >= brr.length) {
                result[k] = arr[i++];
                continue;
            }
            //arr数组已全部处理完，直接把brr的合并到result中
            if (i >= arr.length && j < brr.length) {
                result[k] = brr[j++];
                continue;
            }

            if (arr[i] <= brr[j]) {
                result[k] = arr[i++];
            } else {
                result[k] = brr[j++];
            }
        }
        return result;
    }
}
