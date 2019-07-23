package com.lucida.point.algorithm;

import java.util.Arrays;

/**
 * 算法的学习
 */
public class AlgorithmTest {

    public static void main(String[] args){
        System.out.println("==========算法学习==========");

        System.out.println("1、快速排序");
        quickSort();
        System.out.println("\n");
        System.out.println("============================");
    }

    private static void quickSort(){
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        QuickSortStudy ob = new QuickSortStudy();
        ob.sort(arr, 0, n-1);
//        System.out.println(Arrays.toString(arr));
    }
}
