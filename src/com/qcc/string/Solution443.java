package com.qcc.string;

/**
 * @Description 443. 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * <p>
 * 压缩后的长度必须始终小于或等于原数组长度。
 * <p>
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * <p>
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 *  
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ['a','a','b','b','c','c','c']
 * <p>
 * 输出：
 * 返回6，输入数组的前6个字符应该是：['a','2','b','2','c','3']
 * <p>
 * 说明：
 * 'aa'被'a2'替代。'bb'被'b2'替代。'ccc'被'c3'替代。
 * 示例 2：
 * <p>
 * 输入：
 * ['a']
 * <p>
 * 输出：
 * 返回1，输入数组的前1个字符应该是：['a']
 * <p>
 * 说明：
 * 没有任何字符串被替代。
 * 示例 3：
 * <p>
 * 输入：
 * ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 * <p>
 * 输出：
 * 返回4，输入数组的前4个字符应该是：['a','b','1','2']。
 * <p>
 * 说明：
 * 由于字符'a'不重复，所以不会被压缩。'bbbbbbbbbbbb'被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 注意：
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * @Author qianchaochen
 * @Date 2019年10月11日 11:13
 */
public class Solution443 {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int res = compress(chars);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print("==> " + chars[i] + " ");
        }
    }

    /**
     * @Description 使用快慢指针p和q, p用于统计当前字符出现多少次，q用于记录写入的位置
     * create by qianchaochen at 2019/10/11 14:59
     */
    public static int compress(char[] chars) {
        int count, p = 0, q = 0;
        while (p < chars.length) {
            count = 1;
            while (p < chars.length - 1 && chars[p] == chars[p + 1]) {
                count++;
                p++;
            }
            if (count != 1) {
                char[] arr = String.valueOf(count).toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    chars[++q] = arr[i];
                }
            }
            q++;
            if (p + 1 < chars.length) {
                chars[q] = chars[p + 1];
            }
            p++;
        }
        return q;
    }
}
