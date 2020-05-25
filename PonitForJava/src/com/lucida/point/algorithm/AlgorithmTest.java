package com.lucida.point.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 算法的学习
 */
public class AlgorithmTest {

    public static void main(String[] args){
        System.out.println("==========算法学习==========");

        System.out.println("1、快速排序");
//        quickSort();
        System.out.println("\n");
        System.out.println("============================");

        Map<String,String> map = new HashMap<>();

//        map.put("one","one");

//        System.out.println("结果："+tableSizeFor(0x1f <<< 8));
    }

    private static void quickSort(){
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        QuickSortStudy ob = new QuickSortStudy();
        ob.sort(arr, 0, n-1);
//        System.out.println(Arrays.toString(arr));
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
