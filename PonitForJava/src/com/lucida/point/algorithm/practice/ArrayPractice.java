package com.lucida.point.algorithm.practice;

import java.util.*;

/**
 * 数组算法的练习
 */
public class ArrayPractice {
    public static void main(String[] args) {
//        int[] a = new int[]{1,1,2};
        int[] a = new int[]{7,6,4,3,1};
//        System.out.println(removeDuplicates(a));
        System.out.println(maxProfit(a));
    }

    //给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        Integer[] temp = new Integer[list.size()];
        list.toArray(temp);
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }

        return list.size();
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int temp = prices[0];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j <prices.length; j++) {
                if (prices[j] - prices[i] > temp){
                    temp = prices[j] - prices[i];
                }else {
                    if (i == prices.length -1){
                        temp = 0;
                    }
                }
            }
        }
        return temp;
    }
}
