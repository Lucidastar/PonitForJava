package com.lucida.point.algorithm;

import java.util.Arrays;
import java.util.Collections;

/**
 * 冒泡算法
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int length = arr.length;
        int a = 0;
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
        Integer arr[] = new Integer[]{8,7,6,5};
//        BubbleSort.bubbleSort(arr);
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

//        Arrays.sort();
//        Collections.sort();
    }

    public  static  <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = array.length-1; i >0; i --) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0 ) {
                    T swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


}
