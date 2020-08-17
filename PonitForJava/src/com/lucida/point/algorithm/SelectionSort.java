package com.lucida.point.algorithm;

import java.util.Arrays;

public class SelectionSort {

    public static void selectSort(int[] arrs){
        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arrs.length; j++) {
                if (arrs[minIndex] > arrs[j] ){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arrs[i];
                arrs[i] = arrs[minIndex];
                arrs[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,67,23,45,21,23,1,3,23};
        SelectionSort.selectSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
//        System.out.println(Arrays.toString(arr));
    }
}
