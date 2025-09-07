package com.fengjunzi.algorithms;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HuaDongChuanKouZuiDaHe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int m  = input.nextInt();
        input.close();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < m; i++) {
            deque.offerLast(arr[i]);
            sum += arr[i];
        }
        maxSum = sum;
        for (int i = m; i < n; i++) {
            Integer removed = deque.removeFirst();
            sum -= removed;
            deque.offerLast(arr[i]);
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);

    }
}
