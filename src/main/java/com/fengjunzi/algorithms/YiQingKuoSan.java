package com.fengjunzi.algorithms;

import java.util.*;

public class YiQingKuoSan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = (int) Math.sqrt(arr.length);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / n ][i % n] = arr[i];
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] nextDirection = {{0,1},{0,-1},{1,0},{-1,0}};
        int days = 0;
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < nextDirection.length; j++) {
                    int nextX = cur[0] + nextDirection[j][0];
                    int nextY = cur[1] + nextDirection[j][1];
                    if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || matrix[nextX][nextY] == 1) {
                        continue;
                    }
                    matrix[nextX][nextY] = 1;
                    queue.offer(new int[]{nextX, nextY});
                    flag = true;
                }

            }
            if (flag) {
                days++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);
    }
}
