package com.qcc;

/**
 * @Description
 * @Author 1
 * @Date 2019年05月04日23:04
 */

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution20 {
    public static void main(String[] args) {
        boolean res = isValidNew("()");
        System.out.println(res);

        res = isValidNew("()[]{}");
        System.out.println(res);

        res = isValidNew("(]");
        System.out.println(res);

        res = isValidNew("([)]");
        System.out.println(res);

        res = isValidNew("{[]}");
        System.out.println(res);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            char target;
            switch (curr) {
                case '[':
                case '(':
                case '{':
                    stack.push(curr);
                    break;
                case ']':
                    if(stack.empty()) return false;
                    target = stack.pop();
                    if(target!='[') return false;
                    break;
                case ')':
                    if(stack.empty()) return false;
                    target = stack.pop();
                    if(target!='(') return false;
                    break;
                case '}':
                    if(stack.empty()) return false;
                    target = stack.pop();
                    if(target!='{') return false;
                    break;
            }
        }
        if(stack.empty()) return true;
        return false;
    }

    /**
     * isValid方法的改进
     * @param s
     * @return
     */
    public static boolean isValidNew(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '[' || curr == '{' || curr == '(') {
                stack.push(curr);
            } else {
                if(stack.empty()) return false;
                if(curr==']' && stack.peek()!='[') return false;
                if(curr=='}' && stack.peek()!='{') return false;
                if(curr==')' && stack.peek()!='(') return false;
                stack.pop();
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}
