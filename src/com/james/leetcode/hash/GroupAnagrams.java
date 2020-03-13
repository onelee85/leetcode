package com.james.leetcode.hash;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<String, List<String>> r = new HashMap<>();
            for (String str: strs) {
                String strSorted = strSorted(str);
                List<String> items = r.get(strSorted);
                if(items == null){
                    items =  new ArrayList<String>();
                    r.put(strSorted, items);
                    result.add(items);
                }
                items.add(str);
            }
            return result;
        }

        private String strSorted(String str){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat","tna"};
        List<List<String>> result = new GroupAnagrams.Solution().groupAnagrams(strs);
        for (List<String> list: result) {
            list.forEach(it -> System.out.print(it+" "));
            System.out.println();
        }
    }
}
