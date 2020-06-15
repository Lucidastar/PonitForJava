package com.lucida.point.algorithm;

import java.util.*;

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

        Map<String,String> map = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

//        map.put("one","one");

//        System.out.println("结果："+tableSizeFor(0x1f <<< 8));
    }

    private static void quickSort(){
        int arr[] = {3, 5, 2, 1};
        int n = arr.length;

//        QuickSortStudy ob = new QuickSortStudy();
//        ob.sort(arr, 0, n-1);

//        selectionSort(arr);
        sort(arr);
//        System.out.println(Arrays.toString(sort(arr)));
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

    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int  min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }

    }

    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                    System.out.println(Arrays.toString(arr));
                }

            }

            if (flag) {
                break;
            }
        }
        return arr;
    }
}
