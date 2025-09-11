package com.fengjunzi.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class 翻牌求最大分 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = Arrays.stream(input.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[array.length];
        for(int i =0; i < array.length; i++) {
            int currentScore = (i > 0 ? dp[i - 1] : 0) +  array[i];
            if(i < 3){
                dp[i] = Math.max(currentScore, 0);
            }else{
                if (currentScore > dp[i - 3]) {
                    dp[i] = dp[i-3];
                }else{
                    dp[i] = currentScore;
                }
            }
        }
        System.out.println(dp[array.length - 1]);
        input.close();
    }
}
