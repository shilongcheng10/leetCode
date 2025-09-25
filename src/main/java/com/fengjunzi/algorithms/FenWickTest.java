package com.fengjunzi.algorithms;

import java.util.Scanner;

public class FenWickTest {
    static class FenWickTree{
        int n;
        long[] tree;
        FenWickTree(int n){
            this.n = n;
            this.tree = new long[n+1];
        }

        public void add(int idx, long val){
            while(idx <=n){
                tree[idx] += val;
                idx += idx & -idx;
            }
        }
        public long sum(int idx){
            long res = 0;
            while(idx > 0){
                res += tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }

        public long rangeSum(int left, int right){
            return sum(right) - sum(left - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        FenWickTree tree = new FenWickTree(n);
        for(int i=1; i <=n; i++){
            tree.add(i, sc.nextInt());
        }
        while(q-- > 0){
            int op = sc.nextInt();
            int val1 = sc.nextInt();
            int val2 = sc.nextInt();
            if(op == 1){
                tree.add(val1, val2);
            }else if(op == 2){
                System.out.println(tree.rangeSum(val1, val2));
            }
        }
    }
}
