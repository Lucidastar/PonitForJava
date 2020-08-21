package com.lucida.point.algorithm.practice;

import java.util.*;

/**
 * 数组算法的练习
 */
public class ArrayPractice {
    public static void main(String[] args) {
//        int[] a = new int[]{1,1,2};
        int[] a = new int[]{1,2,4,1,2};
//        System.out.println(removeDuplicates(a));
//        System.out.println(maxProfit(a));
//        System.out.println("Is contain="+containsDuplicate(a));
//        System.out.println("singleNumber="+singleNumber(a));
        System.out.println(2^3);
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{4,4,6,2};
//        System.out.println(Arrays.toString(intersect(nums1,nums2)));
//        System.out.println(Arrays.toString(plusOne(new int[]{0})));

        int[] temp = new int[]{1,4,4,0,0,5,6,0};
//        moveZeroes(temp);
//        System.out.println(Arrays.toString(temp));

        rotate(temp,3);
        System.out.println(Arrays.toString(temp));


//        System.out.println(Arrays.toString(twoSum(new int[]{1,4,3,24,5},7)));
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

    /**
     * 买卖股票的最佳时机 II
     * @param prices
     * @return
     */
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

    /**
     * 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 输入: [2,2,1]
     * 输出: 1
     * {2,2,1,1,3,4,2,3}
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        /*int result = nums[0];
        boolean isEquals = true;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (isEquals){
                result = temp;
            }else {
                break;
            }
            for (int j = 0; j < nums.length; j++) {
                if (i != j){//自己不能和自己比较
                    if (temp == nums[j]){
                        isEquals = true;
                        break;
                    }else {
                        isEquals = false;
                    }
                }
            }
        }
        return result;*/
        int single = 0;
        for (int num : nums) {
//            System.out.println(single+"=="+num);
            System.out.println("二进制："+Integer.toBinaryString(single));
            single ^= num;
            System.out.println(single);
        }
        return single;
    }

    /**
     * 两个数组的交集 II
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> langMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int shotTemp = nums2[i];
            for (int j = 0; j < nums1.length; j++) {
                int longTemp = nums1[j];
                if (shotTemp == longTemp){
                    if (langMap.isEmpty()){//第一次循环
                        langMap.put(j,longTemp);
                        break;
                    }else {
                        if (!langMap.containsKey(j)){//说明这个位置的值已经被用过了
                            langMap.put(j,longTemp);
                            break;
                        }
                    }

                }

            }
        }
        int[] result = new int[langMap.size()];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : langMap.entrySet()){
            result[index] = entry.getValue();
            index ++;
        }
        return result;

    }

    /**
     * 加 一
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0){
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int second = nums[j];
                if (first + second == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static void rotate(int[] nums, int k) {
        int temp,changeTemp;
        for (int i = 0; i < k; i++) {
            changeTemp = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = changeTemp;
                changeTemp = temp;
            }
        }
    }

}
