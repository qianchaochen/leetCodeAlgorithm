package com.qcc;

import java.util.Arrays;

/**
 * @Description 566. 重塑矩阵
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * @Author qianchaochen
 * @Date 2019年10月08日 11:16
 */
public class Solution566 {

    public static void main(String[] args) {
        int nums[][] = {{0,1,2,3},{4,5,6,7},{8,9,10,11}};
        int[][] res = matrixReshape(nums, 4, 4);
        for(int i=0;i<res.length;i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /**
     * @Description 如果新矩阵和原矩阵元素数量不一致，则不能转换，直接返回原矩阵；
     * 循环矩阵中所有元素，注意下标之间的转换关系即可。
     * create by qianchaochen at 2019/10/8 11:28
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, column = nums[0].length;
        if(row*column != r*c) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i/c][i%c] = nums[i/column][i%column];
        }
        return res;
    }
}
