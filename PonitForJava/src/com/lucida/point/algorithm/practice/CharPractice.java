package com.lucida.point.algorithm.practice;

import java.util.*;

public class CharPractice {
    public static void main(String[] args) {
        char[] temp = new char[]{'h','e','l','l','o'};
        reverseString(temp);
        System.out.println(Arrays.toString(temp));

//        System.out.println(reverse(-2147483648));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(test(-2147483648));
//
//        System.out.println(Math.abs(-2147483647));
//        System.out.println(strStr("hello","ll"));
        ;
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        if (left >= right) return;
        while (left <= right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

    }

    public static int reverse(int x) {
        if (x == 0){
            return 0;
        }
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        while (x % 10 == 0){//处理末尾是0的
            x = x / 10;
        }
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = Math.abs(x);
        }
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left <= right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        if (Long.parseLong(String.valueOf(chars)) > Integer.MAX_VALUE){
            return 0;
        }

        return isNegative ? Integer.valueOf("-"+String.valueOf(chars)):Integer.valueOf(String.valueOf(chars));
    }

    private static int test(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 实现 strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int firstUniqChar(String s) {
        if (s != null && s.length() > 0){
            int length = s.length();
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            for (int i = 0; i < length; i++) {
                if (map.get(s.charAt(i)) == 1)
                    return i;
            }
        }
        return -1;
    }


}
