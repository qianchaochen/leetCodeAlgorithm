package com.qcc;

import java.util.Arrays;

/**
 * @Description 561. 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * @Author qianchaochen
 * @Date 2019年10月08日 10:01
 */
public class Solution561 {

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        int res = arrayPairSum(nums);
        System.out.println(res);
    }

    /**
     * @Description 分析：把数组中的数分成两两一对，要保证每对数据中的最小值的和最大，
     * 那么两个数越接近越好，如果两数差值较大，我们只取最小值，那么大数就浪费掉了。使用贪心算法就可以了。
     * 例如 a<b<c<d,那么a+c > a+b,(a,b)与(c,d)的最小值和比(a,c)与(b,d)要大。
     * 所以我们对数组进行排序，然后把相临两个数分为一对，取最小值求和即可。
     * create by qianchaochen at 2019/10/8 10:03
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            res += nums[i];
        }
        return res;
    }

}
