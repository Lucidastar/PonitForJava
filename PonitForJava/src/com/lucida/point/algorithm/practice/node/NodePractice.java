package com.lucida.point.algorithm.practice.node;



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
        ergodicList(node1);
        System.out.println("==============================");
        ergodicList(node);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        ListNode newNode = mergeTwoLists(node1,node);

        ergodicList(newNode);
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

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        int value = head.val;
        while (head.next != null){
            head = head.next;
        }
        return value == head.val;
    }
}
