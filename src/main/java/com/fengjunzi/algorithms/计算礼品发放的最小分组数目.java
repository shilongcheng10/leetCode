package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class 计算礼品发放的最小分组数目 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (visited[i]){
                continue;
            }
            if (array[i] == n){
                count++;
                visited[i] = true;
                continue;
            }

            int j, jtemp = 0;
            int minDuration = Integer.MAX_VALUE;
            for( j = i + 1; j < array.length; j++){
                if (visited[j]){
                    continue;
                }
                if (array[i] + array[j] > n){
                    continue;
                }
                int duration = n - array[i] - array[j];
                if (duration < minDuration){
                    minDuration = duration;
                    jtemp = j;
                }
            }
            if (jtemp !=0){
                visited[i] = true;
                visited[jtemp] = true;
                count++;
            }else{
                visited[i] = true;
                count++;
            }

        }
        System.out.println(count);

    }
}
