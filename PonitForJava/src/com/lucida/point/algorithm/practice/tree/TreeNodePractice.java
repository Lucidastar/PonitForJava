package com.lucida.point.algorithm.practice.tree;


import com.lucida.point.algorithm.practice.node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNodePractice {
    static int i = 0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(50);
        treeNode.left = new TreeNode(40);
        treeNode.right = new TreeNode(40);
        treeNode.right.left = new TreeNode(40);
        treeNode.right.right = new TreeNode(120);
        treeNode.left.left = new TreeNode(300);
        treeNode.left.right = new TreeNode(40);

//        System.out.println(maxDepth(treeNode));
//        System.out.println(isValidBST(treeNode));
//        System.out.println(isSymmetric(treeNode));
        bl(treeNode);
//        factorial(5);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        i++;
        System.out.println("循环次数："+i);
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 验证是否是二叉搜索树
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);

    }


    /**
     *
     * @param node 节点
     * @param lower  下界
     * @param upper  上界
     * @return
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        //当遍历左子树的时候，要把上界改为当前节点的值，即：node.val;,因为左子树的所有节点的值都小于它的根节点的值
        if (! helper(node.left, lower, val)) return false;
        //当遍历右子树的时候，要把下界改为当前节点的值，即：node.val;,因为右子树的所有节点的值都大于它的根节点的值
        if (! helper(node.right, val, upper)) return false;

        return true;
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(--n);
        }
    }

    /**
     * 判断是否是对称二叉树
     * 特点：左孩子的左孩子要与右孩子的右孩子相等
     *      左孩子的右孩子要与右孩子的左孩子相等
     *      也就是从中间切开，能够进行对称，那就是对称二叉树
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left,root.right);
//        return isSymmetric(root,root);
    }

    public static boolean check(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return check(left.left,right.right) && check(left.right,right.left);
    }

    public static boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    public static boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        //某结点只有一个子结点，故不对称，所以返回false
        if(root1 == null || root2 == null){
            return false;
        }

        //对称结点存在，但是值不相同
        if(root1.val != root2.val){
            return false;
        }

        //递归调用左子节点和右子节点
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right,root2.left);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null){

        }
        return lists;
    }

    //遍历节点
    public static void bl(TreeNode root){
        if (root == null){
            return;
        }
//        System.out.println("遍历的值："+root.val);
//        nodeValue(root);
        System.out.println(Arrays.toString(nodeValue(root).toArray()));
//        bl(root.left);
//        bl(root.right);

    }



    //给我一个节点，只要有左子树或者右子树就给你返回一个数组
    public static List<Integer> nodeValue(TreeNode root){
        if (root != null){
            int leftValue;
            int rightValue;
            List<Integer> nodeList = new ArrayList<>();
            if (root.left == null && root.right == null){
                nodeList.add(root.val);
            }
            if (root.left != null){
                leftValue = root.left.val;
                nodeList.add(leftValue);
            }
            if (root.right != null){
                rightValue = root.right.val;
                nodeList.add(rightValue);
            }
            return nodeList;
        }
        return new ArrayList<>();
    }


}
