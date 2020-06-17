package com.james.leetcode.search;

/**
 * 猜数字大小
 *
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class GuessNumber {


    public static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (high >= low){
                int gussNum = low + (high - low ) / 2;
                if(guess(gussNum) == 0)
                    return gussNum;
                else if(guess(gussNum) == -1){ // 比较小
                    high = gussNum - 1;
                }
                else {  // 比较大
                    low = gussNum + 1;
                }
            }
            return -1;
        }

        public int guess(int num){
            if (num < answer) return 1;
            else if (num > answer) return -1;
            else return 0;
        }
    }
    static int answer = 6;

    public static void main(String[] args) {
        System.out.println(new GuessNumber.Solution().guessNumber(10));
    }
}
abstract class GuessGame{
    /**
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 			1 if num is higher than the guess number
     *          otherwise return 0
     */
    abstract public int guess(int num);
}