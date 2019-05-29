package com.james.leetcode.stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 *
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class ReversePolish {

    /**
     * 通过栈的方式来实现，
     *
     * 又逆波兰表达式它不需要括号，运算规则为：运算符在式中出现的顺序恰为表达式的运算顺序；
     * 每个运算符和在它之前出现且紧靠它的两个操作数构成一个最小表达式。
     */
    static class Solution {
        private Stack<Integer> stack = new Stack<Integer>();
        public int evalRPN(String[] tokens) {
            for (int i = 0; i < tokens.length; i++) {
                String str = tokens[i];
                //如果是符号就弹出2个数字 计算完成后压栈
                if(isOperator(str)){
                    stack.push(caculate(stack.pop(), stack.pop(), str));
                }else{//是数字就压栈
                    stack.push(Integer.valueOf(str));
                }
            }
            return stack.pop();
        }

        private Boolean isOperator(String p){
            if(p.equals("+")){
                return Boolean.TRUE;
            }
            if(p.equals("-")){
                return Boolean.TRUE;
            }
            if(p.equals("*")){
                return Boolean.TRUE;
            }
            if(p.equals("/")){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        private int caculate(int num2, int num1, String p){
            switch (p.charAt(0)){
                case '+' : return num1 + num2;
                case '-' : return num1 - num2;
                case '*' : return num1 * num2;
                case '/' : return num1 / num2;
            }
            return 0;
        }
    }


    static class Solution2 {
        public int evalRPN(String[] tokens) {
            int[] stack = new int[tokens.length];
            int top = -1;
            for (String t : tokens) {
                int num1, num2;
                switch (t){
                    case "+" :  num1 = stack[top--];
                                num2 = stack[top];
                                stack[top] = num2 + num1;
                                break;
                    case "-" :  num1 = stack[top--];
                                num2 = stack[top];
                                stack[top] = num2 - num1;
                                break;
                    case "*" :  num1 = stack[top--];
                                num2 = stack[top];
                                stack[top] = num2 * num1;
                                break;
                    case "/" :  num1 = stack[top--];
                                num2  = stack[top];
                                stack[top] = num2 / num1;
                                break;
                    default:
                        stack[++top] = Integer.valueOf(t);
                        break;
                }
            }
            return stack[top];
        }
    }

    public static void main(String[] args) {
        String[] rpns1 = {"2", "1", "+", "3", "*"};
        String[] rpns2 = {"4", "13", "5", "/", "+"};
        String[] rpns3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new ReversePolish.Solution().evalRPN(rpns1));
        System.out.println(new ReversePolish.Solution().evalRPN(rpns2));
        System.out.println(new ReversePolish.Solution().evalRPN(rpns3));

        System.out.println(new ReversePolish.Solution2().evalRPN(rpns1));
        System.out.println(new ReversePolish.Solution2().evalRPN(rpns2));
        System.out.println(new ReversePolish.Solution2().evalRPN(rpns3));
    }

}
