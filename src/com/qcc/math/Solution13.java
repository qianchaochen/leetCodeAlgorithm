package com.qcc.math;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月03日16:57
 */
//Roman to Integer 罗马数字转化成整数

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数转化成数字问题，我们需要对于罗马数字很熟悉才能完成转换。以下截自百度百科：
 *
 * 罗马数字是最早的数字表示方式，比阿拉伯数字早2000多年，起源于罗马。
 * 如今我们最常见的罗马数字就是钟表的表盘符号：Ⅰ，Ⅱ，Ⅲ，Ⅳ（IIII），Ⅴ，Ⅵ，Ⅶ，Ⅷ，Ⅸ，Ⅹ，Ⅺ，Ⅻ……
 * 对应阿拉伯数字（就是现在国际通用的数字），就是1，2，3，4，5，6，7，8，9，10，11，12。（注：阿拉伯数字其实是古代印度人发明的，后来由阿拉伯人传入欧洲，被欧洲人误称为阿拉伯数字。）
 *
 *
 * 基本字符
 * I V  X  L  C   D   M
 * 相应的阿拉伯数字表示为
 * 1 5 10 50 100 500 1000
 *
 * 1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 * 2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 * 3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 * 4、正常使用时，连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）
 * 5、在一个数的上面画一条横线，表示这个数扩大1000倍。
 *
 * 有几条须注意掌握：
 * 1、基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；放在大数的左边只能用一个。
 * 2、不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目，只能使用一个。
 * 3、V 和X 左边的小数字只能用Ⅰ。
 * 4、L 和C 左边的小数字只能用X。
 * 5、D 和M 左边的小数字只能用C。
 *
 * 而这道题好就好在没有让我们来验证输入字符串是不是罗马数字，这样省掉不少功夫。我们需要用到HashMap数据结构，来将罗马数字的字母转化为对应的整数值，因为输入的一定是罗马数字，那么我们只要考虑两种情况即可：
 * 第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字。
 * 第二，其他情况则减去这个数字。
 */
public class Solution13 {

    public static void main(String[] args) {
        int result = romanToInt("III");
        System.out.println(result);

        result = romanToInt("IV");
        System.out.println(result);

        result = romanToInt("IX");
        System.out.println(result);

        result = romanToInt("LVIII");
        System.out.println(result);

        result = romanToInt("MCMXCIV");
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(i == s.length()-1 || map.get(s.charAt(i+1))<=map.get(curr)){
                result += map.get(curr);
            }else{
                result -= map.get(curr);
            }
        }
        return result;
    }
}
