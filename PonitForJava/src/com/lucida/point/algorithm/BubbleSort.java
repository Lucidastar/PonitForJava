package com.lucida.point.algorithm;

import java.util.Arrays;

/**
 * 冒泡算法
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int length = arr.length;
        for (int i = length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,67,23,45,21,23,1,3,23};
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
