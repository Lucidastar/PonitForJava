package com.lucida.point.algorithm.practice.node;


import java.util.ArrayList;
import java.util.List;

public class NodePractice {
    /**
     *  删除链表中的节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        int length=0;
        ListNode node = new ListNode(0);
        node.next = head;
        while (first != null){
            length ++;
            first = first.next;
        }
        //n在节点的倒数第n个，那正着数的话就是length = length-n;
        length -=  n;
        first = node;
        while (length > 0){
            length -- ;
            first = first.next;
        }
        first.next = first.next.next;
        return node.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(0);
        ListNode head = node;
        ListNode head1 = node1;
        for (int i = 1; i < 3; i++) {

            head.next = new ListNode(i);
            head1.next = new ListNode(i);
            head = head.next;
            head1 = head1.next;
        }
//        ergodicList(node1);
//        System.out.println("==============================");
//        ergodicList(node);
//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//        ListNode newNode = mergeTwoLists(node1,node);
        ListNode cycleListNode = createCycleListNode(200);

        System.out.println(hasCycle(cycleListNode));
//        ergodicList(createCycleListNode(5));
//        ergodicList(newNode);
//        System.out.println("==============================");
//        ergodicList(reverseList(node));


    }

    //合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //原先的思路就是遍历两个链表，还在想哪个链表长度长，然后让长的在里层循环
        ListNode listNode = new ListNode(0), cur = listNode;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        //这时候跳出循环 不管哪个链表为空了，都会跳出，然后把不为空的链表直接放到后边就可以了
        cur.next = l1 != null ? l1 : l2;
        return  listNode.next;
    }

    //遍历链表
    private static void ergodicList(ListNode listNode){
        ListNode node = listNode;
        System.out.println(node.val);
        while (node.next != null){
            node = node.next;
            System.out.println(node.val);
        }
    }

    //反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return  cur;
    }

    //请判断一个链表是否为回文链表。
    //先看的的时候，回文链表没有看懂，认为第一个值和最后一个值相等就是回文链表呢？
    //回文链表就是：正着看和倒着看都是一样的
    //比如：  1、 3 、 3 、1 、 1 、 3、 3 、 1
    //正着看： 13311331
    //反着看：13311331
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode listNode = head;

        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <  end){
            if (!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end -- ;
        }
        return true;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode firstNode = head;
        ListNode second = head.next;
        int seconde = 0;
        while (firstNode != second ){
            seconde ++;
            if (second == null || second.next == null){
                return false;
            }
            firstNode = firstNode.next;
            second = second.next.next;
        }
        System.out.println(seconde);
        return true;
    }

    //创建一个有环的链表
    private static ListNode createCycleListNode(int count){
        ListNode first = null;
        ListNode currentNode = null;
        for (int i = 0; i <= count; i++) {
            if (i == 0){
                first = new ListNode(i);
                currentNode = first;
                currentNode.next = first;
                System.out.println("first"+first.hashCode());
                System.out.println("current"+currentNode.hashCode());
                System.out.println("current.next"+currentNode.next.hashCode());
            }else {
                ListNode newNode = new ListNode(i);
                currentNode.next = newNode;
                newNode.next = first;
                currentNode = newNode;
            }
        }
        return first;
    }
}
