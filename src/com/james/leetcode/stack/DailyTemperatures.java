package com.james.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            if(T == null || T.length <= 1)
                return new int[1];
            int[] temps = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                int n = T[i];
                int days = 0;
                int incDays = 0;
                for (int k = i+1; k < T.length; k++) {
                    days++;
                    if(T[k] > n){
                        incDays = days;
                        break;
                    }
                }
                temps[i] = incDays;
            }
            return temps;
        }
    }

    static class Solution2 {
        public int[] dailyTemperatures(int[] T) {
            if(T == null || T.length <= 1)
                return new int[1];
            int[] temps = new int[T.length];
            //递减栈 后入栈的元素总是比先入栈的小
            Stack<Integer> stack = new Stack<>();
            for (int i = T.length-1; i >= 0; i--) {
                //如果当前温度比栈顶的大，则弹栈直到找到比他小的为止
                while(!stack.empty() && T[i] >= T[stack.peek()]){
                    stack.pop();
                }
                if(stack.empty()) {//栈为空，则证明之后所有温度都比他小
                    temps[i] = 0;
                }
                else{
                    temps[i] = stack.peek() - i;
                }
                stack.push(i);
            }
            return temps;
        }
    }

    static class Solution3 {
        public int[] dailyTemperatures(int[] T) {
            if(T == null || T.length <= 1)
                return new int[1];
            int[] res = new int[T.length];
            int[] stack = new int[T.length];
            int top = -1;
            for (int i = 0; i < T.length; i++) {
                while (top != -1 && T[i] > T[stack[top]]){
                    res[stack[top]] = i - stack[top--];
                }
                stack[++top] = i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {73,};
        int[] temperatures3 = {71,70,68,67,66,65};

        int[] temperatures4 = new int[30000];
        Arrays.fill(temperatures4, 30);
        long startTime=System.currentTimeMillis();
        new DailyTemperatures.Solution().dailyTemperatures(temperatures4);
        new DailyTemperatures.Solution().dailyTemperatures(temperatures4);
        int[] res = new DailyTemperatures.Solution().dailyTemperatures(temperatures1);
        System.out.println("Solution3 运行时间： "+(System.currentTimeMillis()-startTime)+"ms");
        for (int num : res) {
            System.out.print(num + ",");
        }
        System.out.println();

        startTime =System.currentTimeMillis();
        new DailyTemperatures.Solution2().dailyTemperatures(temperatures4);
        new DailyTemperatures.Solution2().dailyTemperatures(temperatures4);
        int[] res2 = new DailyTemperatures.Solution2().dailyTemperatures(temperatures1);
        System.out.println("Solution2 运行时间： "+(System.currentTimeMillis()-startTime)+"ms");
        for (int num : res2) {
            System.out.print(num + ",");
        }
        System.out.println();

        startTime =System.currentTimeMillis();
        new DailyTemperatures.Solution3().dailyTemperatures(temperatures4);
        new DailyTemperatures.Solution3().dailyTemperatures(temperatures4);
        int[] res3 = new DailyTemperatures.Solution3().dailyTemperatures(temperatures1);
        System.out.println("Solution3 运行时间： "+(System.currentTimeMillis()-startTime)+"ms");
        for (int num : res3) {
            System.out.print(num + ",");
        }
    }
}
