package com.james.leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class BracketsVail {

    static class Solution {
        private Stack<Character> stack = new Stack<Character>();

        /**
         * 堆栈来解决， 遍历数组，压栈，和栈顶元素比较，匹配则弹栈。
         * 访问完如果栈为空则为有效括号
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            if(s == null || s.equals("") ) return true;
            if(s.length() == 1 || s.length() % 2 != 0) return false;
            for (int i = 0; i < s.length(); i++) {
                Character c = null;
                if(!stack.isEmpty())
                    c = stack.peek();
                if(isMatch(c, s.charAt(i)))
                    stack.pop();
                else{
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(Character c1, Character c2){
            if(c1 == null) return false;
            switch (c2){
                case ')' : return c1=='(';
                case '}' : return c1=='{';
                case ']' : return c1=='[';
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BracketsVail.Solution().isValid("()"));
        System.out.println(new BracketsVail.Solution().isValid("()[]{}"));
        System.out.println(new BracketsVail.Solution().isValid("(]"));
        System.out.println(new BracketsVail.Solution().isValid("([)]"));
        System.out.println(new BracketsVail.Solution().isValid("{[]}"));
        System.out.println(new BracketsVail.Solution().isValid(""));
    }
}
