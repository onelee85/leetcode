package com.james.leetcode.hash;

/**
 * 宝石与石头
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 */
public class NumJewelsInStones {

    static class Solution {
        public int numJewelsInStones(String J, String S) {
            if(J == null || S == null) return 0;
            int[] jewels = new int[58];
            char[] js = J.toCharArray();
            int count = 0;
            for (int i = 0; i < js.length; i++) {
                jewels[js[i]%65] = 1;
            }
            char[] ss = S.toCharArray();
            for (int i = 0; i < ss.length; i++) {
                if(jewels[ss[i]%65] == 1){
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
/*        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.println(i+ ":" + i % 65);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            System.out.println(i % 65);
        }*/
        System.out.println(new NumJewelsInStones.Solution().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new NumJewelsInStones.Solution().numJewelsInStones("z", "ZZ"));
        System.out.println(new NumJewelsInStones.Solution().numJewelsInStones("", ""));
        System.out.println(new NumJewelsInStones.Solution().numJewelsInStones("abcdwerntmqwe", "qpweiaksznxcn"));
        System.out.println(new NumJewelsInStones.Solution().numJewelsInStones("qwertyuiopasdfghjklzxcvbnm", "qwertyuiopasdfghjklzxcvbnm"));
        System.out.println(new NumJewelsInStones.Solution().numJewelsInStones("QWERTYUIOPASDFGHJKLZXCVBNM", "QWERTYUIOPASDFGHJKLZXCVBNM"));
    }
}
