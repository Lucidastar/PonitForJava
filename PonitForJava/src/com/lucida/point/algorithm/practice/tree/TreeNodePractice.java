package com.lucida.point.algorithm.practice.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNodePractice {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        TreeNode temp = root;
        int tempDepth = 0;
        while (temp != null){
            tempDepth++;
            temp = temp.left;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }}, tmp;
        return 0;
    }
}
