package com.lucida.point.algorithm.practice;

import java.util.Arrays;

public class CharPractice {
    public static void main(String[] args) {
        char[] temp = new char[]{'h','e','l','l','o'};
        reverseString(temp);
        System.out.println(Arrays.toString(temp));

        System.out.println(reverse(-2147483648));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(test(-2147483648));
//
//        System.out.println(Math.abs(-2147483647));
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
}
