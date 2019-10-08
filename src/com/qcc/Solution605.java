package com.qcc;

/**
 * @Description 605.种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * @Author qianchaochen
 * @Date 2019年10月08日 13:51
 */
public class Solution605 {
    public static void main(String[] args) {
        int[] flowerbed = {0, 1, 0, 0, 0, 1, 0};
        boolean res = canPlaceFlowers(flowerbed, 2);
        System.out.println(res);
    }

    /**
     * @Description 如果数组首尾有0，则连续2个可种入一朵花。3个种1朵，4个种2朵，5个种2朵，count代表0的个数，即可种 count/2朵
     * 数组中间位置 3个0可种一朵，4个0可种1朵，5个可种2朵，即 (count-1)/2朵。
     * 这样太复杂，在数组前后添加两个虚拟的0
     * create by qianchaochen at 2019/10/8 14:05
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n>0; i++) {
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && flowerbed[i] == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
