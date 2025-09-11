package com.fengjunzi.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GouJianSanChaShu {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode middle;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
        TreeNode(int val, TreeNode left, TreeNode middle, TreeNode right) {
            this.val = val;
            this.left = left;
            this.middle = middle;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println(0);
            return;
        }
        if (n == 1){
            System.out.println(1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        sc.close();
        int height =0;
        TreeNode root = null;
        for (int i = 0; i < list.size(); i++) {
            if (root == null){
                root = new TreeNode(list.get(i));
                height = 1;
            }else{
                height = insertNode(root, list.get(i), 1);
            }
        }
        System.out.println(height);
    }

    private static int insertNode(TreeNode root, Integer num, int height) {
        if(root == null){
            return height;
        }
        if(num < root.val - 500){
            if(root.left == null){
                root.left = new TreeNode(num);
                return height+1;
            }else{
                return insertNode(root.left, num, height+1);
            }
        }else if(num > root.val + 500){
            if(root.right == null){
                root.right = new TreeNode(num);
                return height+1;
            }else{
                return insertNode(root.right, num, height+1);
            }
        }else{
            if(root.middle == null){
                root.middle = new TreeNode(num);
                return height+1;
            }else{
                return insertNode(root.middle, num, height+1);
            }
        }
    }


}
