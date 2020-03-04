package com.james.leetcode.hash;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 两个列表的最小索引总和
 *
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 示例 1:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 示例 2:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 * 提示:
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 */
public class FindRestaurant {

    static class  Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            // 将较少的list放入到hashmap中节省时间（put操作消耗较大）
            if(list1.length>list2.length) return findRestaurant(list2, list1);

            Map<String, Integer> List1Map = new HashMap<>();
            ArrayList<String> results = new ArrayList<>();
            for (int i = 0; i < list1.length; i++) {
                List1Map.put(list1[i], i);
            }
            int minIndex = list1.length + list2.length - 2;
            for (int i = 0; i < list2.length && i <= minIndex; i++) {
                String str = list2[i];
                if(List1Map.containsKey(str)){
                    int index = List1Map.get(str) + i;
                    if(index == minIndex) {
                        results.add(str);
                    }else if(index < minIndex){
                        results.clear();
                        minIndex = index;
                        results.add(str);
                    }
                }
            }
            return results.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        FindRestaurant.Solution s = new FindRestaurant.Solution();
        String[] strs1 = {"Shogun", "Tapioca Express", "KFC", "Burger King"};
        String[] strs2 = {"Tapioca Express", "Shogun", "Burger King"};
        String[] result = s.findRestaurant(strs1, strs2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
