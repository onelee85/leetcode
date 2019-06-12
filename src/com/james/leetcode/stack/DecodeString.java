package com.james.leetcode.stack;

import java.util.Stack;

/**
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {

    static class Solution {
        public String decodeString(String s) {
            if(s == null || s.length() == 0) return "";
            Stack<Character> stack = new Stack<>();
            //循环字符串
            for (int i = 0; i < s.length(); i++) {
                //直到遇到字符 ']'
                char c = s.charAt(i);
                if(c == ']'){
                    String subStr = "";
                    while (stack.peek() != '['){
                        //开始弹栈拼接字符串，直到 '['
                        subStr = stack.pop() + subStr;
                    }
                    stack.pop();
                    //继续弹栈直到非数字的字符, 拼接字符转化为整数N
                    String strN = "";
                    while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9'){
                        strN = stack.pop() + strN;
                    }
                    Integer n = Integer.valueOf(strN);
                    //循环N次 拼接好的字符串，
                    String str = "";
                    while (n-- > 0){
                        str += subStr;
                    }
                    //将拼接好的压入栈中
                    for (int j = 0; j < str.length(); j++) {
                        stack.push(str.charAt(j));
                    }
                }else{
                    //将每个字符压入栈中
                    stack.push(c);
                }

            }

            //最后弹栈拼接字符串
            String decStr = "";
            for (Character c : stack){
                decStr += c;
            }
            return decStr;
        }
    }

    public static void main(String[] args){
        System.out.println(new DecodeString.Solution().decodeString("3[a]2[bc]").equals("aaabcbc"));
        System.out.println(new DecodeString.Solution().decodeString("3[a2[c]]").equals("accaccacc"));
        System.out.println(new DecodeString.Solution().decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
        System.out.println(new DecodeString.Solution().decodeString("100[leetcode]").equals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"));
        System.out.println(new DecodeString.Solution().decodeString("3[a2[cc5[absd3[a]]]]").equals("accabsdaaaabsdaaaabsdaaaabsdaaaabsdaaaccabsdaaaabsdaaaabsdaaaabsdaaaabsdaaaaccabsdaaaabsdaaaabsdaaaabsdaaaabsdaaaccabsdaaaabsdaaaabsdaaaabsdaaaabsdaaaaccabsdaaaabsdaaaabsdaaaabsdaaaabsdaaaccabsdaaaabsdaaaabsdaaaabsdaaaabsdaaa"));
    }
}
