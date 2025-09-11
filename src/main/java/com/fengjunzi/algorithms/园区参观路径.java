package com.fengjunzi.algorithms;

import java.util.Scanner;

public class 园区参观路径 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        input.close();
        int[][] dp = new int[n][m];

        for(int i=0; i < n;i++){
            if (arr[i][0] == 0){
                dp[i][0] = 1;
            }else  {
                dp[i][0] = Integer.MAX_VALUE;
            }
        }
        for (int j = 1; j < m; j++) {
            if (arr[0][j] == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(arr[i][j] == 0 && dp[i-1][j] != Integer.MAX_VALUE && dp[i][j-1] != Integer.MAX_VALUE){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else if(dp[i-1][j] == Integer.MAX_VALUE){
                    dp[i][j] = dp[i][j-1];
                }else if (dp[i][j-1] == Integer.MAX_VALUE){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
