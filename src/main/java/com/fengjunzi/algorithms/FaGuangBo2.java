package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FaGuangBo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length;
        int[][] matrix = new int[n][n];
        matrix[0] = arr;
        FaGuangBo.UnionFind uf = new FaGuangBo.UnionFind(n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
            if(sc.hasNextLine()){
                sc.nextLine();
            }
        }
        boolean [] visited = new boolean[n];
        int count =0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(matrix, visited, i, n);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] matrix, boolean[] visited, int node, int n) {
        visited[node] = true;
        for(int j = 0; j < n; j++){
            if(!visited[j] && matrix[node][j] == 1){
                dfs(matrix, visited, j, n);
            }
        }
    }

}
