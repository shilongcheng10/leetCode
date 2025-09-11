package com.fengjunzi.algorithms;

import java.util.*;

public class WuRanShuiYu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = (int) Math.sqrt(array.length);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            matrix[i / n][i % n] = array[i];
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if(matrix[i][j] == 1){
                   queue.offer(new int[]{i, j});
               }
            }
        }
        if(queue.isEmpty()){
            System.out.println("-1");
            return;
        }
        int days =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for(int j =0; j < 4;j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx < 0 || nx >=n || ny < 0 || ny >=n || matrix[nx][ny] != 0){
                        continue;
                    }
                    matrix[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                    flag = true;
                }

            }
            if(flag){
                days++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(days);
    }
}
