package com.lucida.point.algorithm;

import java.util.Arrays;

/**
 * 冒泡算法
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int length = arr.length;
        int a = 0;
        int b = 0;
        for (int i = length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                a++;
            }

        }
        System.out.println("循环的总次数:"+a);
    }

    public static void main(String[] args) {
//        int arr[] = {4,67,23,45,21,23,1};
        int arr[] = {8,7,6,5};
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
