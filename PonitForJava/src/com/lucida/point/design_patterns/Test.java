package com.lucida.point.design_patterns;

import sun.misc.LRUCache;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    private String name;
    public static final int RED = 0xFFFF0000;
    public static final int INVISIBLE = 0x00000011;
    public static final int IMPORTANT_FOR_AUTOFILL_NO = 0x01002;
    public static void main(String[] args){
        /*System.out.println("hello word");
        try {
            Test test = Test.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

//        play(new File("G:\\360Downloads"));
        /*String strHex3 = "255";
        System.out.println(Integer.parseInt(strHex3,16));
        System.out.println(RED);*/

        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        List list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);

//        list1.retainAll(list2);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }
//
//        Test.ProCheck proCheck = new Test.ProCheck();
//        Prams prams = new Prams();
//        proCheck.getPrams(prams);
//        System.out.println(prams.getAge()+"==="+prams.getName());

        /*System.out.println(IMPORTANT_FOR_AUTOFILL_NO);
        Object o = Collections.max(list1);

            System.out.println(o);*/

        /*float a = 1.0f - 0.9f;
        double b = 0.9f - 0.8f;
        System.out.println(a);
        System.out.println(b);
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(4);
        set.add(6);
        Object[] ints = set.toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        set.clear();
        if (set.contains(2)){
            System.out.println("包含");
        }



        Stack<String> stack = new Stack<>();
        stack.push("name");
        stack.push("age");
        stack.add("sex");
        while (!stack.isEmpty()){
            String pop = stack.pop();
            System.out.println(pop);
        }


        int[] array=new int[]{17,8,23,46,12,7,85,74};
        QuickSort(array, 0, array.length-1);
        *//*for(int i=0;i<array.length;i++)
        {
            System.out.println((i+1)+"th:"+array[i]);
        }*//*

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(0, 0.75f, true);
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","2");
        linkedHashMap.put("3","3");
        linkedHashMap.put("4","4");
        linkedHashMap.put("5","5");

        linkedHashMap.get("1");
//        linkedHashMap.put("6","6");
//        linkedHashMap.put("7","7");
//        linkedHashMap.get("6");
//        linkedHashMap.get("1");
//        linkedHashMap.put("8","8");
        System.out.println("=========================================");
        for (Map.Entry entry : linkedHashMap.entrySet()){
//            System.out.println(entry.getKey());
        }

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("9");
        linkedList.add("8");
        linkedList.add("7");
        linkedList.add("6");
        linkedList.add("5");
        linkedList.add("4");
        linkedList.add("3");
        for (int i = 0; i < linkedList.size(); i++) {
//            System.out.println(linkedList.get(i));
        }

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {

            map.put(String.valueOf(i),"张三");
        }*/

//        System.out.println(map.get("50"));

//        System.out.println(countPrimes(10));
//        System.out.println(Math.sqrt(4));
//        System.out.println(isPowerOfThree(6));
        System.out.println(fib(6));

    }

    public static int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        int num = 0;
        for(int i = 2 ; i <= n ; i++){
            if(searchZhishu(i)){
                num++;
            }
        }
        return num;
    }


    public static boolean searchZhishu(int num) {
        for(int i=2; i<num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while ( n % 3 == 0){
            n /= 3;
        }
        return n ==1;
    }




        private static String format(String[] replaceKey,String content){
        StringBuilder stringBuilder = new StringBuilder();
        Pattern p=Pattern.compile(replaceKey[0]+"(\\w+)"+replaceKey[1]);
        Matcher m=p.matcher(content);
        while(m.find()){
            stringBuilder.append(m.group(1)).append("=");
        }
        return stringBuilder.toString();
    }

    private static List<String> format1(String[] replaceKey,String content){
        List<String> resutl = new ArrayList<>();
        Pattern p = Pattern.compile(replaceKey[0] + "(\\w+)" + replaceKey[1]);
        Matcher m = p.matcher(content);
        while (m.find()) {
            resutl.add(m.group(1));
        }
        return resutl;
    }


    private static void QuickSort(int[] array,int start,int end)
    {
        if(start<end)
        {
            int key=array[start];
            int i=start,j;
            for(j=start+1;j<=end;j++)
            {
                if(array[j]<key)
                {
                    int temp=array[j];
                    array[j]=array[i+1];
                    array[i+1]=temp;
                    i++;
                }

                System.out.println(Arrays.toString(array));
            }
            array[start]=array[i];
            array[i]=key;

            QuickSort(array, start, i-1);
            QuickSort(array, i+1, end);

        }

    }

    public String getName(){
        return name;
    }

    static void play(File file){
        File[] files = file.listFiles();
        for (int i = 0 ; i < files.length ; i ++){
            if (files[i].isFile()){
                System.out.println(files[i].getName());
            }else {
                play(files[i]);
            }
        }
    }

    static class ProCheck{

        public void getPrams(Prams paras){
            paras.setAge((int)(1+Math.random()*(10-1+1))+"");
            paras.setName("这是名字");
        }
    }

    static class Prams{
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    static int yuesefu(int n,int m){
        if(n == 1){
            return 0;
        }
        else{
            return (yuesefu(n-1,m) + m) % n;
        }
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }
}
