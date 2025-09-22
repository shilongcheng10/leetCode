package com.fengjunzi.algorithms;

import java.util.Scanner;

/*
给定一个很大的数组 L（下标假设从 1 开始或 0 开始均可），有两类操作按行输入：
        •	操作 1 number1 number2：把 number2 加到 L[number1] 上（单点增量）。
        •	操作 2 number1 number2：返回 L[number1..number2] 的区间和（或题意是前缀和到 number2，描述中有两种写法，这里按区间和通用处理）。
要在数组很大、操作很多的情况下把运行时间控制在 1s 内（即高性能）。*/
public class FenWick {
    static class FenWickTree{
        int n;
        long[] tree;
        FenWickTree(int n){
            this.n = n;
            tree = new long[n+1];
        }

        public void add(int idx, int val){
            while(idx <= n){
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        public long sum(int idx){
            long res = 0;
            while(idx > 0){
                res+= tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }

        public long rangeSum(int left, int right){
            return sum(right) - sum(left-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        FenWickTree fenWickTree = new FenWickTree(n);
        for (int i = 1; i <= n; i++) {
            fenWickTree.add(i, arr[i]);
        }
        while (q-- > 0) {
            int op = scanner.nextInt();
            int idx = scanner.nextInt();
            int val = scanner.nextInt();
            if(op == 1){
                fenWickTree.add(idx, val);
            }else if(op == 2){
                System.out.println(fenWickTree.rangeSum(idx, val));
            }
        }

    }
}
