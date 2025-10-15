package com.fengjunzi.algorithms;

import java.util.ArrayList;
import java.util.List;

// https://www.hello-algo.com/chapter_dynamic_programming/knapsack_problem/ 0-1背包问题
public class knapsackDP {
    /* 0-1 背包：动态规划 */
    int knapsackDP2(int[] wgt, int[] val, int cap) {
        int[][] dp = new int[wgt.length + 1][cap + 1];
        for (int i = 1; i <= wgt.length; i++) {
            for (int j = 1; j <= cap; j++) {
                if (wgt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],  dp[i - 1][j - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[wgt.length][cap];
    }

    // 01 背包， 动态规划 退化为1维数组
    int knapsackDP1(int[] wgt, int[] val, int cap) {
        int[] dp = new int[cap + 1];
        for (int i = 1; i <= wgt.length; i++) {
            for(int j = cap;j >= wgt[i];j--){
                dp[j] = Math.max(dp[j], dp[j - wgt[i - 1]] + val[i - 1]);
            }
        }
        return dp[cap];
    }

    // 0-1 背包找到如何选择的
    List<Integer> reConstruct(int[] wgt, int[] val, int cap) {
        int[][] dp =new int[wgt.length + 1][cap + 1];
        for (int i = 1; i <= wgt.length; i++) {
            for(int j = cap;j >= wgt[i];j--){
                dp[i][j] = dp[i - 1][j];
                if (j >= wgt[i]) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - wgt[i]] + val[i - 1]);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int j = cap;
        for (int i = wgt.length; i >=1; i--) {
            if (dp[i][j] != dp[i - 1][j]) {
                res.add(i-1);
                j-=wgt[i-1];
            }
        }
        return res;
    }

    //完全背包问题
    int unboundedKnapsackDP(int[] wgt, int[] val, int cap) {
        int[][] dp = new int[wgt.length + 1][cap + 1];
        for (int i = 1; i <= wgt.length; i++) {
            for(int j = 1; j<=cap;j++){
                dp[i][j] = dp[i-1][j];
                if (j >= wgt[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-wgt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[wgt.length][cap];
    }

    //完全背包问题 1维数组
    public int unboundedKnapsackDPComp(int[] wgt, int[] val, int cap) {
        int[] dp = new int[cap + 1];
        for (int i = 1; i <= wgt.length; i++) {
            for(int j =1;j<=cap;j++){
                if (wgt[i - 1] > j) {
                    // 若超过背包容量，则不选物品 i
                    dp[j] = dp[j];
                } else {
                    // 不选和选物品 i 这两种方案的较大值
                    dp[j] = Math.max(dp[j], dp[j - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[cap];
    }
}
