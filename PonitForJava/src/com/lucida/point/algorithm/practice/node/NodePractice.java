package com.lucida.point.algorithm.practice.node;

import java.util.LinkedList;

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
        for (int i = 1; i < 10; i++) {
            while (head.next != null){
                head = head.next;
            }
            while (head1.next != null){
                head1 = head1.next;
            }
            head.next = new ListNode(i);
            head1.next = new ListNode(i);
        }
//        ListNode newNode = mergeTwoLists(node1,node);
//        ergodicList(node1);
        for (int i=0;i<0;i++) {
            System.out.println("hello");
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(Math.min(l1.val,l2.val));
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        while (l1Node.next != null){
            int l1Value = l1Node.val;
            l1Node = l1.next;
            while (l2Node.next != null){
                int l2Value = l2Node.val;
                l2Node = l2Node.next;
                if (l2Value > l1Value){

                    break;
                }else {
                    listNode = listNode.next = new ListNode(l1Value);
                }

            }
        }



        return  listNode;
    }

    private static void ergodicList(ListNode listNode){
        ListNode node = listNode;
        while (node.next != null){
            node = node.next;
            System.out.println(node.val);
        }
    }

}
