package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FaGuangBo {
    /**
     * 并查集
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        int[][] matrix = new int[n][n];
        matrix[0] = arr;
        UnionFind uf = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();

            }
            if(sc.hasNextLine()){
                sc.nextLine();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1;j < n; j++){
                if(matrix[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (uf.parent[i] == i) {
                count++;
            }
        }
        System.out.println(count);
    }

   static class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int preX = find(x);
            int preY = find(y);
            if (preX  > preY) {
                parent[preY] = preX;
            }else if (preX < preY) {
                parent[preX] = preY;
            }else{
                parent[preY] = preX;
                rank[preX]++;
            }
        }
   }
}
