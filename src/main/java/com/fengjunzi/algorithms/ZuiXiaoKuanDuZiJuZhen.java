package com.fengjunzi.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZuiXiaoKuanDuZiJuZhen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int [][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int targetCnt = input.nextInt();
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < targetCnt; i++) {
            int num = input.nextInt();
            targetMap.put(num, targetMap.getOrDefault(num, 0) + 1);
        }
        input.close();
        int minWidth = Integer.MAX_VALUE;
        int left =0, right = 0;
        while(right < m){
            while (right < m && !isAllExisting(targetMap, arr, left, right)){
                right++;
            }
            while(right < m && left <= right && isAllExisting(targetMap, arr, left, right)){
                minWidth = Math.min(minWidth, right - left + 1);
                left++;
            }
            left = right+1;
            right = left;
        }
        System.out.println(minWidth == Integer.MAX_VALUE ? -1 : minWidth);
    }

    private static boolean isAllExisting(Map<Integer, Integer> targetMap, int[][] arr, int left, int right){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = left; j <=right;j++){
                if (targetMap.containsKey(arr[i][j]) && map.getOrDefault(arr[i][j], 0) < targetMap.get(arr[i][j])) {
                    map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : targetMap.entrySet()) {
            if (!map.containsKey(entry.getKey())){
                return false;
            }
            if (entry.getValue() > map.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }


}
