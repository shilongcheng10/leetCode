package com.fengjunzi.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class XuNiLiCai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalMoney = sc.nextInt();
        int maxRisk = sc.nextInt();
        int[] returnArr =  new int[n];
        for (int i = 0; i < n; i++) {
            returnArr[i] = sc.nextInt();
        }
        int[] riskArr = new int[n];
        for (int i = 0; i < n; i++) {
            riskArr[i] = sc.nextInt();
        }
        int[] maxBuyArr = new int[n];
        for (int i = 0; i < n; i++) {
            maxBuyArr[i] = sc.nextInt();
        }
        sc.close();
        Map<Integer[], Integer> map = new HashMap<>();
        for(int i =0; i < n-1;i++){
            int earnedMoney = returnArr[i];
            int risk = riskArr[i];
            int buyCount = maxBuyArr[i];
            int curEarnedMoney = earnedMoney * buyCount;
            int maxSecondEarnedMoney = 0;
            int jtemp = i+1;
            for(int j = i + 1; j < n;j++){
                if (maxRisk - risk - riskArr[j] < 0 || totalMoney - maxBuyArr[i] - maxBuyArr[j] < 0){
                    continue;
                }
                if (returnArr[j] * maxBuyArr[j]  > maxSecondEarnedMoney){
                    maxSecondEarnedMoney = returnArr[j] * maxBuyArr[j];
                    jtemp = j;
                }
            }
            if (maxSecondEarnedMoney !=0){

                map.put(new Integer[]{i, jtemp}, curEarnedMoney + returnArr[jtemp] * maxBuyArr[jtemp]);
            }
        }
        List<Integer> result = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey)
                .map(item -> Arrays.stream(item).toList()).get();
        for (int i = 0; i < n; i++) {
            if (result.contains(i)) {
                System.out.print(maxBuyArr[i] + " ");
            }else{
                System.out.print(0 + " ");
            }
        }

    }
}
