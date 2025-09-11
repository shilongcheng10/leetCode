package com.fengjunzi.algorithms;

import java.util.Scanner;

public class ZuiDuoGouMaiBaoShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int money = sc.nextInt();
        int left =0, right =0;
        int sum = 0;
        int maxCn = Integer.MIN_VALUE;
        while(right < n){
            sum += arr[right];
            while(left <= right && sum > money){
                sum -= arr[left];
                left++;
            }
            maxCn = Math.max(maxCn, right - left+1);
            right++;
        }
        System.out.println(maxCn);
    }
}
